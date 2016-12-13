/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter6.item35;

/**
 * ClassName: Sample <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月8日 下午2:30:10 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Sample {
  @Test
  public static void m1() {
  } // Test should pass

  public static void m2() {
  }

  @Test
  public static void m3() { // Test Should fail
    throw new RuntimeException("Boom");
  }

  public static void m4() {
  }

  @Test
  public void m5() {
  } // INVALID USE: nonstatic method

  public static void m6() {
  }

  @Test
  public static void m7() { // Test should fail
    throw new RuntimeException("Crash");
  }

  public static void m8() {
  }

}
