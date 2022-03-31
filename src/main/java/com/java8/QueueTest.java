package com.java8;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.DelayQueue;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.Delayed;

public class QueueTest {

    @Test
    public void test001() throws InterruptedException {
        //基于数组的有界队列
        ArrayBlockingQueue<Integer> aq = new ArrayBlockingQueue<>(2);

        aq.add(1);
        aq.add(2);

        boolean offer = aq.offer(3);
        System.out.println("offer = " + offer);
        //获取元素 不移除
        Integer peek = aq.peek();
        System.out.println("peek = " + peek);

        Integer take = aq.take();
        System.out.println("take = " + take);


        aq.put(4);

        Integer poll = aq.poll(1, TimeUnit.SECONDS);
        System.out.println("poll = " + poll);

        System.out.println("aq = " + aq);
    }

    /**
     * ArrayBlockingQueue ： 不支持读写同时操作，底层基于数组的。
     * LinkedBlockingQueue：支持读写同时操作，并发情况下，效率高。底层基于链表。
     *
     * @throws InterruptedException
     */
    @Test
    public void test002() throws InterruptedException {
        //基于数组的有界队列
        LinkedBlockingQueue<Integer> lq = new LinkedBlockingQueue<>();

        lq.add(1);
        lq.add(2);

        boolean offer = lq.offer(3);
        System.out.println("offer = " + offer);

        Integer take = lq.take();
        System.out.println("take = " + take);
        lq.put(4);

        Integer poll = lq.poll(1, TimeUnit.SECONDS);
        System.out.println("poll = " + poll);

        System.out.println("integerBlockingQueue = " + lq);

        //21亿
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
    }

    public static void main(String[] args) throws InterruptedException {
        test003();
    }


    /**
     * 线程与线程间一对一传递消息的模型
     * 从结果可以看出，put线程执行queue.put(1) 后就被阻塞了，只有take线程进行了消费，put线程才可以返回。可以认为这是一种线程与线程间一对一传递消息的模型。
     * take线程read的状态，put操作才执行
     *
     * @throws InterruptedException
     */
    public static void test003() throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        //创建一个线程，取数据：
        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread run...");

                try {
                    System.out.println("synchronousQueue.take:" + synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                System.out.println("take thread end...");
            }
        });
        //搞一个线程，往里面放数据：
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread run...");
                try {
                    synchronousQueue.put("aaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("put thread end...");
            }
        });

        putThread.start();
        Thread.sleep(1000);
        takeThread.start();
    }

    @Test
    public void test004() throws InterruptedException {
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

        priorityBlockingQueue.put(3);
        priorityBlockingQueue.put(2);
        priorityBlockingQueue.put(1);

        System.out.println("priorityBlockingQueue = " + priorityBlockingQueue);
        int size = priorityBlockingQueue.size();

        for (int i = 0; i < size; i++) {
            System.out.println("priorityBlockingQueue.take() = " + priorityBlockingQueue.take());
        }
    }

    @Test
    public void test005() throws InterruptedException {
        DelayQueue<Delayed> delayQueue = new DelayQueue<>();

        long currentTimeMillis = System.currentTimeMillis();
        delayQueue.put(new Student("AAA", currentTimeMillis + 5000));
        delayQueue.put(new Student("BBB", currentTimeMillis + 2000));
        delayQueue.put(new Student("CCC", currentTimeMillis + 1000));

        System.out.println("delayQueue = " + delayQueue);

        while (!delayQueue.isEmpty()) {
            System.out.println("for start");
            System.out.println("delayQueue.take() = " + delayQueue.take());
            System.out.println("wait time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Test
    public void test006() throws InterruptedException {
        Deque<String> deque = new LinkedList<>();

        deque.offer("B");
        deque.offer("C");

        deque.offerLast("D");
        deque.offerFirst("A");
        System.out.println("deque = " + deque);


        deque.pollLast();
        deque.pollFirst();
        System.out.println("deque = " + deque);


    }

}
