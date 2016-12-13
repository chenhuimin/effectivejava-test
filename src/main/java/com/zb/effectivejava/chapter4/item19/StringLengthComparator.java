/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter4.item19;

/**
 * ClassName: StringLengthComparator <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年11月25日 下午3:19:11 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class StringLengthComparator {
  private StringLengthComparator() {
  }

  public static final StringLengthComparator INSTANCE = new StringLengthComparator();

  public int compare(String s1, String s2) {
    return s1.length() - s2.length();
  }

  public static void main(String[] args) {

  }

}
