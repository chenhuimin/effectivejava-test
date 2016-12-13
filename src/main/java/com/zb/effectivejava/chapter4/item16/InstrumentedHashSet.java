/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter4.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * ClassName: InstrumentedHashSet <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年11月22日 下午2:31:40 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
  private int addCount = 0;

  public InstrumentedHashSet() {

  }

  public InstrumentedHashSet(int initCap, float loadFactor) {
    super(initCap, loadFactor);

  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  /**
   * 获取addCount的值.
   *
   * @return addCount
   */
  public int getAddCount() {
    return addCount;
  }

  public static void main(String[] args) {
    InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
    s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
    System.out.println(s.getAddCount());

  }

}
