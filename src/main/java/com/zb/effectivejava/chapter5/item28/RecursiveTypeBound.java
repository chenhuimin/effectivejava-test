/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item28;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName: RecursiveTypeBound <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月6日 下午4:29:54 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class RecursiveTypeBound {
  public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
    Iterator<? extends T> iterator = list.iterator();
    T result = iterator.next();
    while (iterator.hasNext()) {
      T next = iterator.next();
      if (next.compareTo(result) > 0) {
        result = next;
      }

    }
    return result;

  }

  public static void main(String[] args) {
    List<String> argList = Arrays.asList(args);
    System.out.println(max(argList));

  }

}
