/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.rest;

import javax.ws.rs.core.Response.StatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.WebResource;

/**
 * ClassName: SaltstackRestController <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月12日 下午5:14:11 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
@RestController
@RequestMapping("/api")
public class DockerRestController {
  @Autowired
  private Client client;

  @RequestMapping(value = "/docker", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String docker() {
    String requestUrl = "https://192.168.222.45:6732/containers/json";
    String result = null;
    WebResource resource = client.resource(requestUrl);
    ClientResponse response = resource.get(ClientResponse.class);
    StatusType statusInfo = response.getStatusInfo();
    if (Status.OK.equals(statusInfo)) {
      result = response.getEntity(String.class);
    }
    return result;
    // HttpGet httpGet = new HttpGet(url);
    // RequestConfig requestConfig =
    // RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(3000).setSocketTimeout(10000)
    // .build();
    // httpGet.setConfig(requestConfig);
    // String result = null;
    // CloseableHttpResponse response = null;
    // try {
    // response = httpClient.execute(httpGet);
    // if (response != null) {
    // HttpEntity resEntity = response.getEntity();
    // if (resEntity != null) {
    // result = EntityUtils.toString(resEntity, "UTF-8");
    // }
    // }
    // } catch (ClientProtocolException e) {
    //
    // e.printStackTrace();
    //
    // } catch (IOException e) {
    //
    // e.printStackTrace();
    //
    // } finally {
    // httpGet.releaseConnection();
    // if (response != null) {
    // try {
    // response.close();
    // } catch (IOException e) {
    //
    // e.printStackTrace();
    //
    // }
    // }
    // }
    // return result;

  }

}
