package com.java8.thread;

public class CustomerThread extends Thread {//消费者线程
    //共享商品：
    private Product p;

    public CustomerThread(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {//i:消费次数
            p.lock.lock();
            try {
                if (!p.isFlag()) {
                    p.customerCondition.await();
                }
                System.out.println("消费者消费了：" + p.getBrand() + "---" + p.getName());
                p.setFlag(false);
                p.producerCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                p.lock.unlock();
            }
        }
    }

    public void run2() {
        for (int i = 1; i <= 10; i++) {//i:消费次数
            synchronized (p) {
                if (!p.isFlag()) {
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("消费者消费了：" + p.getBrand() + "---" + p.getName());
                p.setFlag(false);
                p.notify();
            }
        }
    }
}