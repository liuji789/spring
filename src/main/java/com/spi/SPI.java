package com.spi;

import java.util.ServiceLoader;

public class SPI {

  public static void main(String[] args) {
    ServiceLoader<IShout> iShouts = ServiceLoader.load(IShout.class);

    for (IShout iShout : iShouts) {
      // 遍历
      iShout.shout();
    }
  }
}
