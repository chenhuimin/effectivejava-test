/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.item26.first;

import java.util.Arrays;

/**
 * ClassName: Stack <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月5日 下午5:33:34 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Stack<E> {
  private E[] elements;
  private int size = 0;
  private static final int DEFAULT_INITAL_CAPACITY = 16;

  public Stack() {
    elements = (E[]) new Object[DEFAULT_INITAL_CAPACITY];

  }

  public void push(E e) {
    ensureCapacity();
    elements[size++] = e;
  }

  public E pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    E result = elements[--size];
    elements[size] = null;
    return result;

  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void ensureCapacity() {
    if (elements.length == size) {
      elements = Arrays.copyOf(elements, 2 * size + 1);
    }

  }

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    for (String arg : args) {
      stack.push(arg);
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop().toUpperCase());
    }

  }

}
