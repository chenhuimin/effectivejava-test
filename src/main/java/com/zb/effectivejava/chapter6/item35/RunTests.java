/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter6.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: RunTests <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月8日 下午2:36:45 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class RunTests {
  public static void main(String[] args) throws Exception {
    int tests = 0;
    int passed = 0;
    Class<?> testClass = Class.forName(args[0]);
    for (Method m : testClass.getDeclaredMethods()) {
      if (m.isAnnotationPresent(Test.class)) {
        tests++;
        try {
          m.invoke(null);
          passed++;
        } catch (InvocationTargetException wrappedExc) {
          Throwable exc = wrappedExc.getCause();
          System.out.println(m + " failed: " + exc);
        } catch (Exception exc) {
          System.out.println("INVALID @Test: " + m);
        }
      }

      if (m.isAnnotationPresent(ExceptionTest.class)) {
        tests++;
        try {
          m.invoke(null);
          System.out.printf("Test %s failed: no exception%n", m);
        } catch (Throwable wrappedExc) {
          Throwable exc = wrappedExc.getCause();
          Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
          int oldPassed = passed;
          for (Class<? extends Exception> excType : excTypes) {
            if (excType.isInstance(exc)) {
              passed++;
              break;
            }
          }
          if (passed == oldPassed) {
            System.out.printf("Test %s failed: %s %n", m, exc);
          }
        }
      }
    }
    System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);

  }

}
