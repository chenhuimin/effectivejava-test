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
import java.util.Set;

/**
 * ClassName: InstrumentedSet <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年11月22日 下午2:56:36 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
  private int addCount = 0;

  public InstrumentedSet(Set<E> s) {

    super(s);

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

  public int getAddCount() {
    return addCount;
  }

  public static void main(String[] args) {
    InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<String>());
    s.addAll(Arrays.asList("a", "b", "c"));
    System.out.println(s.getAddCount());

  }

}
