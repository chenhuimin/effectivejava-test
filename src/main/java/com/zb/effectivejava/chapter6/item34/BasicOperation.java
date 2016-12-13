/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter6.item34;

/**
 * ClassName: BasicOperation <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月8日 上午11:00:59 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public enum BasicOperation implements Operation {
  PLUS("+") {

    @Override
    public double apply(double x, double y) {

      return x + y;
    }

  },
  MINUS("-") {

    @Override
    public double apply(double x, double y) {

      return x - y;
    }

  },
  TIMES("*") {

    @Override
    public double apply(double x, double y) {

      return x * y;
    }

  },
  DIVIDE("/") {

    @Override
    public double apply(double x, double y) {

      return x / y;
    }

  };

  private final String symbol;

  private BasicOperation(String symbol) {

    this.symbol = symbol;

  }

  @Override
  public String toString() {

    return symbol;
  }

}
