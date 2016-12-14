package com.zb.effectivejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandler;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.apache4.ApacheHttpClient4Handler;

@SpringBootApplication
public class Application {

  @Value("${docker-registry.cert.password}")
  private String password;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Client getJerseyClient() {
    ClientConfig cc = new DefaultClientConfig();
    cc.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 10 * 1000);
    cc.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, 10 * 1000);
    ClientHandler apacheHttpClient4Handler = new ApacheHttpClient4Handler(getHttpClient(), new BasicCookieStore(), true);
    Client client = new Client(apacheHttpClient4Handler, cc);
    return client;

  }

  @Bean
  public CloseableHttpClient getHttpClient() {
    FileInputStream instream = null;
    SSLContext sslcontext = null;
    Set<KeyManager> keymanagers = new LinkedHashSet<>();
    Set<TrustManager> trustmanagers = new LinkedHashSet<>();
    try {
      KeyStore keyStore = KeyStore.getInstance("PKCS12");
      ClassLoader classLoader = getClass().getClassLoader();
      instream = new FileInputStream(new File(classLoader.getResource("docker_cert/cert.p12").getFile()));
      keyStore.load(instream, password.trim().toCharArray());
      final KeyManagerFactory kmfactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmfactory.init(keyStore, password.trim().toCharArray());
      final KeyManager[] kms = kmfactory.getKeyManagers();
      if (kms != null) {
        for (final KeyManager km : kms) {
          keymanagers.add(km);
        }
      }
      trustmanagers.add(new HttpsTrustManager());
      KeyManager[] km = keymanagers.toArray(new KeyManager[keymanagers.size()]);
      TrustManager[] tm = trustmanagers.toArray(new TrustManager[trustmanagers.size()]);
      sslcontext = SSLContexts.custom().build();
      sslcontext.init(km, tm, new SecureRandom());
    } catch (KeyStoreException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (CertificateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (UnrecoverableKeyException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (KeyManagementException e) {
      e.printStackTrace();
    } finally {
      if (instream != null) {
        try {
          instream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }
    SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslcontext,
        SSLConnectionSocketFactory.getDefaultHostnameVerifier());
    HttpClientBuilder httpClientBuilder = HttpClients.custom();
    httpClientBuilder.setSSLSocketFactory(factory);
    // 重试次数，默认是3次，没有开启
    httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
    // 保持长连接配置，需要在头添加Keep-Alive
    httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());

    List<Header> headers = new ArrayList<>();
    headers.add(new BasicHeader("User-Agent",
        "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36"));
    headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
    headers.add(new BasicHeader("Accept-Language", "zh-CN"));
    headers.add(new BasicHeader("Connection", "Keep-Alive"));
    httpClientBuilder.setDefaultHeaders(headers);
    CloseableHttpClient httpClient = httpClientBuilder.build();
    return httpClient;
  }

  public static class HttpsTrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[] {};
    }

  }

}
