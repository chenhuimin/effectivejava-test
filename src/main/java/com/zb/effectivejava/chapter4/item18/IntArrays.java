/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter4.item18;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: IntArrays <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年11月24日 下午3:54:11 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class IntArrays {
  public static List<Integer> intArrayAsList(final int[] a) {
    return new AbstractList<Integer>() {

      @Override
      public Integer get(int index) {

        // TODO Auto-generated method stub
        return a[index];
      }

      @Override
      public int size() {

        // TODO Auto-generated method stub
        return a.length;
      }

      @Override
      public Integer set(int index, Integer element) {
        int oldValue = a[index];
        a[index] = element;
        return oldValue;
      }
    };

  }

  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
    List<Integer> list = intArrayAsList(a);
    Collections.shuffle(list);
    System.out.println(list);

  }

}
