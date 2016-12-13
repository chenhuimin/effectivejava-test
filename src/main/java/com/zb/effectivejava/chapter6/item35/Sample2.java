/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter6.item35;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Sample2 <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月8日 下午2:57:43 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Sample2 {

  @ExceptionTest(ArithmeticException.class)
  public static void m1() {
    int i = 0;
    i = i / i;
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m2() {
    int[] a = new int[0];
    int i = a[1];
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m3() {

  }

  @ExceptionTest({ IndexOutOfBoundsException.class, NullPointerException.class })
  public static void doublyBad() {
    List<String> list = new ArrayList<>();
    list.addAll(5, null);

  }

}
