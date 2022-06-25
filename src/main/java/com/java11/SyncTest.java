package com.java11;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author qingn
 * @Auther: liuji
 * @Date: 2022/5/10 - 05 - 10 - 0:10
 * @Description: com.java11
 * @version: 1.0
 */
public class SyncTest {

    public static void main(String[] args) {
        Object monitor = new Object();
        System.out.println("ClassLayout.parseInstance(monitor).toPrintable() = " + ClassLayout.parseInstance(monitor).toPrintable());
    }

}
