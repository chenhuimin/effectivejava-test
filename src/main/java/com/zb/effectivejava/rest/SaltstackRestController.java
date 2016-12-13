/// *
// * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
// *
// *
// *
// */
//
// package com.zb.effectivejava.rest;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;
//
/// **
// * ClassName: SaltstackRestController <br/>
// * Function: TODO (描述这个类的作用) <br/>
// * Date: 2016年12月12日 下午5:14:11 <br/>
// *
// * @author chenhuimin@zillionfortune.com
// * @see
// * @version
// * @since JDK 1.7
// */
// @RestController
// @RequestMapping("/api/test")
// public class SaltstackRestController {
// @Autowired
// private RestTemplate restTemplate;
//
// @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
// public String login(@RequestBody String json) {
// String url = "https://192.168.227.11:8000/login";
// HttpEntity<String> request = new HttpEntity<>(json);
// String result = restTemplate.postForObject(url, request, String.class);
// return result;
//
// }
//
//
//
// }
