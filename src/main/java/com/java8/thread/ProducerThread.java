package com.java8.thread;

public class ProducerThread extends Thread {//生产者线程
    //共享商品：
    private Product p;

    public ProducerThread(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            p.lock.lock();
            try {
                if (p.isFlag()) {
                    p.producerCondition.await();
                }
                if (i % 2 == 0) {
                    //生产费列罗巧克力
                    p.setBrand("费列罗");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    p.setName("巧克力");
                } else {
                    //生产哈尔滨啤酒
                    p.setBrand("哈尔滨");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    p.setName("啤酒");
                }
                //将生产信息做一个打印：
                System.out.println("生产者生产了：" + p.getBrand() + "---" + p.getName());

                p.setFlag(true);
                p.customerCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                p.lock.unlock();
            }
        }
    }

    public void run2() {
        for (int i = 1; i <= 10; i++) {//生产十个商品 i:生产的次数
            synchronized (p) {
                if (p.isFlag()) {
                    try {
                        //
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 == 0) {
                    //生产费列罗巧克力
                    p.setBrand("费列罗");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    p.setName("巧克力");
                } else {
                    //生产哈尔滨啤酒
                    p.setBrand("哈尔滨");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    p.setName("啤酒");
                }
                //将生产信息做一个打印：
                System.out.println("生产者生产了：" + p.getBrand() + "---" + p.getName());

                p.setFlag(true);
                p.notify();

            }
        }
    }
}