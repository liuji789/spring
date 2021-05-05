package com.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * 对象::非静态方法
 * 类::惊天方法
 * 类::非静态方法
 */
public class MethodRefTest {

    /**
     * 对象::实例方法
     * 当传递给lambda体的操作，已经有实现的方法，就可以使用方法引用。
     */
    @Test
    public void test001(){
        Consumer<String> consumer = Str -> System.out.println("Str = " + Str);
        consumer.accept("北京");

        PrintStream printStream = System.out;
        Consumer<String> consumer1 = printStream::println;
        consumer1.accept("北京 method ref");
    }

    @Test
    public void test002(){
        Employee employee = new Employee(999, "999", 1, 99999);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println("supplier.get() = " + supplier.get());

        Supplier<String> supplier1 = employee::getName;
        System.out.println("supplier1.get() = " + supplier1.get());

    }

    @Test
    public void test003(){
        Comparator<Integer> comparator = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println("comparator.compare(1,2) = " + comparator.compare(1, 2));

        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println("comparator1.compare(1,2) = " + comparator1.compare(1, 2));
    }

    @Test
    public void test004(){
        Function<Double,Long> function = d -> Math.round(d);
        System.out.println("function.apply(12.3) = " + function.apply(12.3));

        Function<Double,Long> function1  = Math::round;
        System.out.println("function1.apply(12.5) = " + function1.apply(12.5));
    }
}
