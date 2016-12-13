/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Union <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月6日 下午3:51:40 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Union {
  public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.addAll(s2);
    return result;

  }

  public static void main(String[] args) {
    Set<String> guys = new HashSet<>(Arrays.asList("Tom", "Dick", "Harry"));
    Set<String> stooges = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
    Set<String> aflCio = union(guys, stooges);
    System.out.println(aflCio);

  }

}
