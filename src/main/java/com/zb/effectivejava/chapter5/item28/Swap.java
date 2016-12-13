/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item28;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Swap <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月7日 上午10:47:45 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Swap {
  public static void swap(List<?> list, int i, int j) {
    swapHelper(list, i, j);

  }

  private static <E> void swapHelper(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));
  }

  public static void main(String[] args) {
    List<String> argList = Arrays.asList(args);
    swap(argList, 0, argList.size() - 1);
    System.out.println(argList);

  }

}
