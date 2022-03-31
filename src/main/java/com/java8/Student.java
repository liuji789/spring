package com.java8;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Student implements Delayed {

    private String name;
    private Long endTime;

    public Student(String name, Long endTime) {
        this.name = name;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Student other = (Student) o;
        return endTime.compareTo(other.getEndTime());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", endTime=" + endTime +
                '}';
    }
}
