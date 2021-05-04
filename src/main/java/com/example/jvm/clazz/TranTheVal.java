package com.example.jvm.clazz;


/**
 * 类文件具有错误的版本 54.0, 应为 52.0
 */
public class TranTheVal {
    public static void main(String[] args) throws Exception{


        long start = System.currentTimeMillis();
        int size = 10000;
//        Fiber<Void>[] fibers = new Fiber[size];
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i] = new Fiber<>(() -> {
//
//                calc();
//
//            });
//        }
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i].start();
//        }
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i].join();
//        }

        Thread[] threads = new Thread[size];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                calc();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static void calc() {
        int result = 0;
        for (int m = 0; m < 10000; m++) {
            for (int i = 0; i < 200; i++) {
                result += i;
            } ;
        }
    }
}
