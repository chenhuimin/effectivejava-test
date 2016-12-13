/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter6.item31;

/**
 * ClassName: Ensemble <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月7日 下午4:43:54 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public enum Ensemble {
  DUET(2), TRIO(3), QUARTET(4), SOLO(1), QUINTET(5);

  private final int numberOfMusicians;

  private Ensemble(int size) {
    this.numberOfMusicians = size;
  }

  public int numberOfMusicians() {
    return numberOfMusicians;

  }

  public static void main(String[] args) {
    System.out.println(Ensemble.SOLO.numberOfMusicians());

  }

}
