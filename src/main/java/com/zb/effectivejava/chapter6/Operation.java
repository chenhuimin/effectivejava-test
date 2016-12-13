/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter6;

/**
 * ClassName: Operation <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月7日 下午3:15:40 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public enum Operation {
  PLUS("+") {
    @Override
    double apply(double x, double y) {

      return x + y;
    }
  },
  MINUS("-") {
    @Override
    double apply(double x, double y) {

      return x - y;
    }

  },
  TIMES("*")

  {
    @Override
    double apply(double x, double y) {

      return x * y;
    }
  },
  DIVIDE("/") {
    @Override
    double apply(double x, double y) {

      return x / y;
    }
  };
  private final String symbol;

  private Operation(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {

    return symbol;
  }

  abstract double apply(double x, double y);

  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    // for (Operation op : Operation.values()) {
    // System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    // }
    Operation oper = Operation.valueOf("PLUS");
    System.out.println(oper.apply(x, y));

  }

}
