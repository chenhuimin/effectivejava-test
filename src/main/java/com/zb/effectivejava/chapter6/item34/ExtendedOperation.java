/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter6.item34;

import java.util.Arrays;
import java.util.Collection;

/**
 * ClassName: ExtendedOperation <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月8日 上午11:22:12 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public enum ExtendedOperation implements Operation {
  EXP("^") {

    @Override
    public double apply(double x, double y) {
      return Math.pow(x, y);
    }

  },
  REMAINDER("%") {

    @Override
    public double apply(double x, double y) {

      return x % y;
    }

  };

  private final String symbol;

  private ExtendedOperation(String symbol) {

    this.symbol = symbol;

  }

  @Override
  public String toString() {

    return symbol;
  }

  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    test(ExtendedOperation.class, x, y);
    System.out.println();
    test2(Arrays.asList(ExtendedOperation.values()), x, y);

  }

  private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
    for (Operation op : opSet.getEnumConstants()) {
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

    }

  }

  private static void test2(Collection<? extends Operation> opSet, double x, double y) {
    for (Operation op : opSet) {
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
  }

}
