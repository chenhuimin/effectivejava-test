/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter4.item16;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * ClassName: ForwardingSet <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年11月22日 下午2:51:04 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class ForwardingSet<E> implements Set<E> {
  private final Set<E> s;

  public ForwardingSet(Set<E> s) {

    this.s = s;

  }

  @Override
  public int size() {

    // TODO Auto-generated method stub
    return s.size();
  }

  @Override
  public boolean isEmpty() {

    // TODO Auto-generated method stub
    return s.isEmpty();
  }

  @Override
  public boolean contains(Object o) {

    // TODO Auto-generated method stub
    return s.contains(o);
  }

  @Override
  public Iterator<E> iterator() {

    // TODO Auto-generated method stub
    return s.iterator();
  }

  @Override
  public Object[] toArray() {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a) {

    // TODO Auto-generated method stub
    return s.toArray(a);
  }

  @Override
  public boolean add(E e) {

    // TODO Auto-generated method stub
    return s.add(e);
  }

  @Override
  public boolean remove(Object o) {

    // TODO Auto-generated method stub
    return s.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {

    // TODO Auto-generated method stub
    return s.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {

    // TODO Auto-generated method stub
    return s.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {

    // TODO Auto-generated method stub
    return s.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {

    // TODO Auto-generated method stub
    return s.removeAll(c);
  }

  @Override
  public void clear() {

    // TODO Auto-generated method stub
    s.clear();

  }

  @Override
  public boolean equals(Object obj) {

    // TODO Auto-generated method stub
    return s.equals(obj);
  }

  @Override
  public int hashCode() {

    // TODO Auto-generated method stub
    return s.hashCode();
  }

  @Override
  public String toString() {

    // TODO Auto-generated method stub
    return s.toString();
  }

}
