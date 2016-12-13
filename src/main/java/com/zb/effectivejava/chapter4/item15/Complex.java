/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter4.item15;

/**
 * ClassName: Complex <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年11月21日 下午2:46:00 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public final class Complex {
  private final double re;
  private final double im;

  /**
   * TODO(对象创建说明，如何被创建的).
   *
   * @param re
   * @param im
   */

  private Complex(double re, double im) {

    this.re = re;
    this.im = im;
  }

  public static Complex valueOf(double re, double im) {
    return new Complex(re, im);
  }

  public static final Complex ZERO = new Complex(0, 0);
  public static final Complex ONE = new Complex(1, 0);
  public static final Complex I = new Complex(0, 1);

  /**
   * 获取re的值.
   *
   * @return re
   */
  public double getRe() {
    return re;
  }

  /**
   * 获取im的值.
   *
   * @return im
   */
  public double getIm() {
    return im;
  }

  public Complex add(Complex c) {
    return new Complex(re + c.re, im + c.im);
  }

  public Complex subtract(Complex c) {
    return new Complex(re - c.re, im - c.im);
  }

  public Complex multiply(Complex c) {
    return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
  }

  public Complex divide(Complex c) {
    double tmp = c.re * c.re + c.im * c.im;
    return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
  }

  /**
   * TODO 简单描述该方法的实现功能（可选）.
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(im);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(re);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  /**
   * TODO 简单描述该方法的实现功能（可选）.
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Complex other = (Complex) obj;

    return Double.compare(re, other.re) == 0 && Double.compare(im, other.im) == 0;
  }

  /**
   * TODO 简单描述该方法的实现功能（可选）.
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Complex [re=" + re + ", im=" + im + "]";
  }

}
