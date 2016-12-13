/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item25;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Reduction <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月5日 下午4:41:24 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Reduction {
  static <E> E reduce(List<E> list, Function<E> f, E initVal) {
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

  private static final Function<Integer> SUM = new Function<Integer>() {

    @Override
    public Integer apply(Integer arg1, Integer arg2) {

      return arg1 + arg2;
    }
  };

  private static final Function<Integer> PRODUCT = new Function<Integer>() {

    @Override
    public Integer apply(Integer arg1, Integer arg2) {

      return arg1 * arg2;
    }
  };
  private static final Function<String> CONNECT_STR = new Function<String>() {

    @Override
    public String apply(String arg1, String arg2) {

      return arg1 + arg2;
    }
  };

  public static void main(String[] args) {
    // List<Integer> intList = Arrays.asList(1, 2, 3);
    // List<String> strList = Arrays.asList("a", "b", "c");
    // System.out.println(reduce(intList, SUM, 0));
    // System.out.println(reduce(strList, CONNECT_STR, ""));
    int size = 0;
    System.out.println(size++);
    System.out.println(size);
    System.out.println(--size);
    System.out.println(size);

  }

}
