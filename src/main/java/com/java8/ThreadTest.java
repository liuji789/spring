package com.java8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        new Thread("thread thread") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " i = " + i);
                }
            }
        }.start();


        Callable callable = (Callable<String>) () -> {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
            return "ok";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);

        Thread futureTaskThread = new Thread(futureTask, "callable thread");
        futureTaskThread.start();


        Thread.currentThread().setName("thread mian");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(2);
            System.out.println(Thread.currentThread().getName() + " i = " + i);
            futureTaskThread.join();
        }

        if (futureTask.isDone()) {
            System.out.println("futureTask.get() = " + futureTask.get());
        }

    }

}

class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub thread i = " + i);
            }
        });

        //伴随线程
        thread.setDaemon(true);

        thread.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(2);
            System.out.println("i = " + i);
        }

    }
}

/**
 * 锁 同步监视器
 */
class SyncMonitorTest {
    public static void main(String[] args) {
        ThreadTestImpl threadTest1 = new ThreadTestImpl();
        ThreadTestImpl threadTest2 = new ThreadTestImpl();
        ThreadTestImpl threadTest3 = new ThreadTestImpl();

        threadTest1.setName("1");
//        threadTest1.start();

        threadTest2.setName("2");
//        threadTest2.start();

        threadTest3.setName("3");
//        threadTest3.start();

        ThreadTestImpl2 threadTest21 = new ThreadTestImpl2();
        ThreadTestImpl2 threadTest22 = new ThreadTestImpl2();
        ThreadTestImpl2 threadTest23 = new ThreadTestImpl2();

        threadTest21.setName("21");
        threadTest21.start();

        threadTest22.setName("22");
        threadTest22.start();

        threadTest23.setName("23");
        threadTest23.start();

    }
}

class ThreadTestImpl extends Thread {

    static Integer ticketNum = 10;

    static Object monitor = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor) {
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + " get the ticket " + ticketNum--);
                }
            }

        }
    }
}

class ThreadTestImpl2 extends Thread {

    static Integer ticketNum = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellTicket();
        }
    }

    /**
     * 同步方法static
     * 非静态同步方法是this
     * 静态同步方法是.class 字节码信息对象
     */
    private static synchronized void sellTicket() {
        if (ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + " get the ticket " + ticketNum--);
        }

    }
}


/**
 * 代码块 可扩展
 */
class ThreadTestImpl3 extends Thread {

    public static void main(String[] args) {
        ThreadTestImpl3 threadTest31 = new ThreadTestImpl3();
        ThreadTestImpl3 threadTest32 = new ThreadTestImpl3();
        ThreadTestImpl3 threadTest33 = new ThreadTestImpl3();

        threadTest31.setName("31");
        threadTest31.start();

        threadTest32.setName("32");
        threadTest32.start();

        threadTest33.setName("33");
        threadTest33.start();
    }

    static Integer ticketNum = 10;

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + " get the ticket " + ticketNum--);
                }
            } finally {
                lock.unlock();
            }

        }
    }

}


class TestDeadLock implements Runnable {

    public static void main(String[] args) {
        // 实例2个线程类
        TestDeadLock td1 = new TestDeadLock();
        TestDeadLock td2 = new TestDeadLock();
        td1.flag = 1;
        td2.flag = 0;
        // 开启2个线程
        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td2);
        t1.start();
        t2.start();
    }

    public int flag = 1;
    static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        // 当flag==1锁住o1
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 只要锁住o2就完成
                synchronized (o2) {
                    System.out.println("2");
                }
            }
        }
        // 如果flag==0锁住o2
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 只要锁住o1就完成
                synchronized (o1) {
                    System.out.println("3");
                }
            }
        }
    }
}
