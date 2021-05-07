package com.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author admin
 * Streamg关注的是对数据的计算，和cpu打交道
 * collection集合是对数据的存储，和内存打交道
 *
 * ①自己不存储元素
 * ②不改变源对象，而是生成新的持有结果的新的Stream
 * ③操作时延迟执行的，在需要结果的时候才执行
 *
 * Stream实例化->中间操作->终止操作
 */
public class StreamTest {

    /**
     * 创建Stream的方式
     */
    @Test
    public void test001(){
        //通过集合
        List<Employee> emplees = EmployeeData.getEmplees();
        Stream<Employee> stream = emplees.stream();
        System.out.println("stream = " + stream);
        Stream<Employee> parallelStream = emplees.parallelStream();
        System.out.println("parallelStream = " + parallelStream);
        //通过数组
        int[] ints = {1, 2, 3};
        IntStream stream1 = Arrays.stream(ints);
        System.out.println("stream1 = " + stream1);

        Employee[] employees = {new Employee(1,"name1",1,1),new Employee(2,"name2",2,2)};
        Stream<Employee> stream2 = Arrays.stream(employees);
        System.out.println("stream2 = " + stream2);
        //Stream.of
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("integerStream = " + integerStream);
        //创建无限流
        //迭代
        Stream.iterate(0,t ->t+2).limit(10).forEach(System.out::println);
        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    /**
     * 中间操作：筛选与切片
     * filter 接收lambda，从流中排除某些元素。
     * limit 截断流，使元素不超过给定数量。
     * skip 跳过元素，返回一个扔掉了前n个元素的流
     * distinct 筛选，通过流的所生成元素的hashCode和equals去除重复元素。
     */
    @Test
    public void test002(){
        //查询薪水大于100的Employee
        EmployeeData.getEmplees().stream().filter(employee -> employee.getSalary() > 100).forEach(System.out::println);

    }

    /**
     * 映射
     */
    @Test
    public void test003(){
        List<String> list = Arrays.asList("aa","bb","cc");
        //接收一个函数作为参数，
        Stream<String> stream = list.stream().map(String::toUpperCase);
        stream.forEach(System.out::println);

        /**
         * 获取员工姓名长度大于3的员工的姓名
         */
        List<Employee> emplees = EmployeeData.getEmplees();
        emplees.stream().map(Employee::getName).filter(name -> name.length() >3).forEach(System.out::println);

    }

    public static Stream<Character> stringToStream(String s){
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }

        return characterList.stream();
    }

    @Test
    public void test999(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        List list1 = new ArrayList();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        //list = [1, 2, 3, [4, 5, 6]] 4个元素
        //list.add(list1);
        //list = [1, 2, 3, 4, 5, 6] 6 个元素
        list.addAll(list1);
        System.out.println("list = " + list);
    }
}
