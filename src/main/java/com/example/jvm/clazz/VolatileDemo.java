package com.example.jvm.clazz;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

class MyData {

    volatile int  count = 0;

    void addCount() {
        count = 60;
    }

}


public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.addCount();

        }


        ).start();


        while (myData.count == 0){

        }

        System.out.println("myData.count = " + myData.count);

    }

    public static  boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;

    }

}
