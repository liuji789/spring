package com.example.jvm.errorAppend;

/**
 * @author liuji
 * @create 2019-06-24 9:58
 */
public class test {


    private static final int _1MB= 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * Java堆大小20M,10M新生代,10M老年代
     */
    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[ 2 * _1MB];
        allocation2 = new byte[ 2 * _1MB];
        allocation3 = new byte[ 2 * _1MB];
        allocation4 = new byte[ 4 * _1MB];
    }


    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+PrintCommandLineFlags
     * -XX:+UseSerialGC
     */
    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
//        testAllocation();
        testPretenureSizeThreshold();
    }
}
