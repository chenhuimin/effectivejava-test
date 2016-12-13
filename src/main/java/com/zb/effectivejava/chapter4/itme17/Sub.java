/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter4.itme17;

import java.util.Date;

/**
 * ClassName: Sub <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年11月22日 下午4:00:06 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Sub extends Super {
  private final Date date;

  public Sub() {
    date = new Date();
  }

  @Override
  public void overrideMe() {
    System.out.println(date);
  }

  public static void main(String[] args) {
    Sub sub = new Sub();
    sub.overrideMe();

  }

}
