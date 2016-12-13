/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */

package com.zb.effectivejava.chapter5.iten29;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Favorites <br/>
 * Function: TODO (描述这个类的作用) <br/>
 * Date: 2016年12月7日 上午11:04:43 <br/>
 * 
 * @author chenhuimin@zillionfortune.com
 * @see
 * @version
 * @since JDK 1.7
 */
public class Favorites {
  private Map<Class<?>, Object> favorites = new HashMap<>();

  public <T> void putFavorite(Class<T> type, T instance) {
    if (type == null) {
      throw new NullPointerException("Type is null");
    }
    favorites.put(type, instance);
  }

  public <T> T getFavorite(Class<T> type) {
    return type.cast(favorites.get(type));
  }

  public static void main(String[] args) {

    Map<Class<?>, Object> favorites = new HashMap<>();
    favorites.put(String.class, "Java");
    favorites.put(Integer.class, 0xcafebabe);
    favorites.put(Class.class, Favorites.class);

    String favoriteString = String.class.cast(favorites.get(String.class));
    int favoriteInteger = Integer.class.cast(favorites.get(Integer.class));
    Class<?> favoriteClass = Class.class.cast(favorites.get(Class.class));
    System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

    // Favorites f = new Favorites();
    // f.putFavorite(String.class, "Java");
    // f.putFavorite(Integer.class, 0xcafebabe);
    // f.putFavorite(Class.class, Favorites.class);
    //
    // String favoriteString = f.getFavorite(String.class);
    // int favoriteInteger = f.getFavorite(Integer.class);
    // Class<?> favoriteClass = f.getFavorite(Class.class);
    // System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

  }

}
