/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Reduction <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月6日 下午6:57:56 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Reduction {
  static <E> E reduce(List<? extends E> list, Function<E> f, E initVal) {
    List<E> snapshot;
    synchronized (list) {
      snapshot = new ArrayList<>(list);
    }
    E result = initVal;
    for (E e : snapshot) {
      result = f.apply(result, e);

    }
    return result;
  }

  private static final Function<Number> MAX = new Function<Number>() {

    @Override
    public Number apply(Number n1, Number n2) {

      return Double.compare(n1.doubleValue(), n2.doubleValue()) > 0 ? n1 : n2;
    }
  };

  public static void main(String[] args) {
    List<Integer> intList = Arrays.asList(2, 7, 1, 8, 2, 8, 1, 8, 2, 8);
    System.out.println(reduce(intList, MAX, Integer.MIN_VALUE));

  }

}
