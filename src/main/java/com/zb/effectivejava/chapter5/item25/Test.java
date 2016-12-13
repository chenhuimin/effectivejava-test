/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item25;

/**
 * ClassName: Test <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月5日 下午4:30:34 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Test {
  public static void main(String[] args) {
    /*
     * Object[] objectArray = new Long[1];
     * objectArray[0] = "I don't fit in";
     */
    // List<Object> ol = new ArrayList<Long>();
    String sonarAnlsUrl = "";
    String line = "ANALYSIS SUCCESSFUL, you can browse http://sonar.zbcloud.com:9000/dashboard/index/com.zb:ecc";
    int sonarIndex = line.indexOf("http://sonar.zbcloud.com:9000/dashboard/index/");
    if (sonarIndex != -1) {
      sonarAnlsUrl = line.substring(sonarIndex);
    }
    System.out.println(sonarAnlsUrl);
  }

}
