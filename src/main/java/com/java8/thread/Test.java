package com.java8.thread;

/**
 * 在java对象中，有两种池
 * 锁池-----------synchronized
 * 等待池---------wait notify notifyAll
 * 如果一个线程调用某个对象的wait方法，那么该线程进入该对象的等待池中（并且已经将锁释放）
 * 如果未来的某一时刻，另外一个线程调用了相同对象的notify方法或者notifyAll方法，那么该对象的等待池就会被唤醒，然后进入该对象的锁池里面获取该对象的锁
 * 如果获得锁成功后，那么该线程沿着wait方法之后的代码继续执行。
 *
 * 必须放在同步方法或者同步代码块内才生效
 *
 * lock 拥有一个同步队列和多个等待队列
 */
public class Test {
    //这是main方法，程序的入口
    public static void main(String[] args) {
        //共享的商品：
        Product p = new Product();
        //创建生产者和消费者线程：
        ProducerThread pt = new ProducerThread(p);
        CustomerThread ct = new CustomerThread(p);
        pt.start();
        ct.start();
    }
}