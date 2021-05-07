package com.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
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
    public void test001() {
        Consumer<String> consumer = Str -> System.out.println("Str = " + Str);
        consumer.accept("北京");

        PrintStream printStream = System.out;
        Consumer<String> consumer1 = printStream::println;
        consumer1.accept("北京 method ref");
    }

    @Test
    public void test002() {
        Employee employee = new Employee(999, "999", 1, 99999);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println("supplier.get() = " + supplier.get());

        Supplier<String> supplier1 = employee::getName;
        System.out.println("supplier1.get() = " + supplier1.get());

    }

    @Test
    public void test003() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println("comparator.compare(1,2) = " + comparator.compare(1, 2));

        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println("comparator1.compare(1,2) = " + comparator1.compare(1, 2));
    }

    @Test
    public void test004() {
        Function<Double, Long> function = d -> Math.round(d);
        System.out.println("function.apply(12.3) = " + function.apply(12.3));

        Function<Double, Long> function1 = Math::round;
        System.out.println("function1.apply(12.5) = " + function1.apply(12.5));
    }

    /**
     * 类::非静态方法，s1作为方法的调用者，s2作为参数。
     */
    @Test
    public void test005() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println("comparator.compare(\"abc\",\"abd\") = " + comparator.compare("abc", "abd"));

        Comparator<String> comparator1 = String::compareTo;
        System.out.println("comparator1.compare(\"abc\",\"abe\") = " + comparator1.compare("abc", "abe"));
    }

    @Test
    public void test006(){
        BiPredicate<String,String> biPredicate = (s1,s2) -> s1.equals(s2);
        System.out.println("biPredicate.test(\"abc\",\"abc\") = " + biPredicate.test("abc", "abc"));

        BiPredicate<String,String> biPredicate1 = String::equals;
        System.out.println("biPredicate1.test(\"abc\",\"abc\") = " + biPredicate1.test("abc", "abc"));
    }

    /**
     * 方法引用，返回的类型一致
     * 调用的是类的实例对象，传递this。
     */
    @Test
    public void test007(){
        Employee employee = new Employee(999, "999", 1, 99999);
        Function<Employee,String> function = employee1 -> employee1.getName();
        System.out.println("function.apply(employee) = " + function.apply(employee));

        Function<Employee,String> function1 = Employee::getName;
        System.out.println("function1.apply(employee) = " + function1.apply(employee));
    }

    /**
     * 构造器引用
     */
    @Test
    public void test008(){
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println("supplier.get() = " + supplier.get());

        Supplier<Employee> supplier1 = Employee::new;
        System.out.println("supplier1.get() = " + supplier1.get());
    }

    @Test
    public void test009(){
        BiFunction<Integer,String,Employee> biFunction = (age,name) -> new Employee(age,name);
        System.out.println("biFunction.apply(1,\"1name\") = " + biFunction.apply(1, "1name"));

        BiFunction<Integer,String,Employee> biFunction1 = Employee::new;
        System.out.println("biFunction1.apply(1,\"1name\") = " + biFunction1.apply(1, "1name"));
    }

    @Test
    public void test010(){
        Function<Integer,String[]> function = (length) -> new String[length];
        System.out.println("function.apply(2) = " + Arrays.toString(function.apply(2)));

        Function<Integer,String[]> function1 = String[]::new;
        System.out.println("function1.apply(2) = " + Arrays.toString(function1.apply(2)));
    }
}
