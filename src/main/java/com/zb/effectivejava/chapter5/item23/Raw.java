/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item23;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: Raw <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月5日 上午10:38:46 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Raw {
  public static void main(String[] args) {
    // List<String> strings = new ArrayList<>();
    // unsafeAdd(strings, new Integer(42));
    // String s = strings.get(0);
    Set<?> s1 = new HashSet<>();
    Object o1 = "test";
    // s1.addAll(o1);

  }

  private static void unsafeAdd(List list, Object o) {
    list.add(o);

  }

  static int rawNumElementsInCommon(Set s1, Set s2) {
    int result = 0;
    for (Object o1 : s1) {
      if (s2.contains(o1)) {
        result++;
      }
    }
    return result;

  }

  static int numElementsInCommon(Set<?> s1, Set<?> s2) {
    int result = 0;
    for (Object o1 : s1) {
      if (s2.contains(o1)) {
        result++;
      }
    }
    return result;
  }

}
