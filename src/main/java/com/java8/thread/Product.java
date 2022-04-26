package com.java8.thread;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = -6859807468833914659L;//商品类
    //品牌
    private String brand;
    //名字
    private String name;
    //引入一个灯：true:红色  false 绿色
    boolean flag = false;//默认情况下没有商品 让生产者先生产  然后消费者再消费

    Lock lock = new ReentrantLock();

    Condition producerCondition = lock.newCondition();

    Condition customerCondition = lock.newCondition();

    //setter,getter方法；
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}