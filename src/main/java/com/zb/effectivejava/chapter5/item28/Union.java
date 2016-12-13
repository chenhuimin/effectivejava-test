/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item28;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Union <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月7日 上午10:08:55 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Union {

  public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.addAll(s2);
    return result;

  }

  public static void main(String[] args) {
    Set<Integer> integers = new HashSet<>();
    integers.add(1);
    integers.add(3);
    integers.add(5);

    Set<Double> doubles = new HashSet<>();
    doubles.add(2.0);
    doubles.add(4.0);
    doubles.add(6.0);
    Set<Number> numbers = union(integers, doubles);
    System.out.println(numbers);

  }

}
