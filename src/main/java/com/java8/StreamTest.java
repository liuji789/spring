package com.java8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.bouncycastle.math.Primes;
import org.junit.Test;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

/**
 * @author admin
 * Streamg关注的是对数据的计算，和cpu打交道
 * collection集合是对数据的存储，和内存打交道
 * <p>
 * ①自己不存储元素
 * ②不改变源对象，而是生成新的持有结果的新的Stream
 * ③操作时延迟执行的，在需要结果的时候才执行
 * <p>
 * Stream实例化->中间操作->终止操作
 */
public class StreamTest {

    /**
     * 创建Stream的方式
     */
    @Test
    public void test001() {
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

        Employee[] employees = {new Employee(1, "name1", 1, 1), new Employee(2, "name2", 2, 2)};
        Stream<Employee> stream2 = Arrays.stream(employees);
        System.out.println("stream2 = " + stream2);
        //Stream.of
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("integerStream = " + integerStream);
        //创建无限流
        //迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
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
    public void test002() {
        //查询薪水大于100的Employee
        EmployeeData.getEmplees().stream().filter(employee -> employee.getSalary() > 100).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");
        EmployeeData.getEmplees().stream().limit(3).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");
        EmployeeData.getEmplees().stream().skip(3).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");
        EmployeeData.getEmplees().stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射
     * map:接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap:接收一个函数作为参数，将流中的每个值换成另一个流，然后把所以流连接成一个流
     */
    @Test
    public void test003() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        //接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        Stream<String> stream = list.stream().map(String::toUpperCase);
        stream.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");
        /**
         * 获取员工姓名长度大于3的员工的姓名
         */
        List<Employee> emplees = EmployeeData.getEmplees();
        emplees.stream().map(Employee::getName).filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");
        //接收一个函数作为参数，将流中的每个值换成另一个流，然后把所以流连接成一个流
        //类似于 list.add 和 list.addAll的区别
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest::stringToStream);
        streamStream.forEach(inStream -> inStream.forEach(System.out::println));
        System.out.println("--------------------------------------------------------------");

        list.stream().flatMap(StreamTest::stringToStream).forEach(System.out::println);

    }

    /**
     * 自然排序
     * 定制排序
     */
    @Test
    public void test004() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, -1, -4, 8, 11);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------------------");

        EmployeeData.getEmplees().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------------------");

        EmployeeData.getEmplees().stream().sorted((o1, o2) -> {
            int ageCompare = Integer.compare(o1.getAge(), o2.getAge());
            if (ageCompare == 0) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
            return ageCompare;
        }).forEach(System.out::println);

    }

    /**
     * 终止操作
     * 匹配与查找
     * allMatch : 匹配所以元素。anyMatch:任意元素满足。noneMatch：没有元素满足要求，则返回true。
     */
    @Test
    public void test005() {
        boolean allMatch = EmployeeData.getEmplees().stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println("allMatch = " + allMatch);
        System.out.println("--------------------------------------------------------------------------------------------------");
        boolean anyMatch = EmployeeData.getEmplees().stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println("anyMatch = " + anyMatch);
        System.out.println("--------------------------------------------------------------------------------------------------");
        boolean noneMatch = EmployeeData.getEmplees().stream().noneMatch(employee -> employee.getName().startsWith("万"));
        System.out.println("noneMatch = " + noneMatch);
        System.out.println("--------------------------------------------------------------------------------------------------");
        Optional<Employee> first = EmployeeData.getEmplees().stream().findFirst();
        System.out.println("first.get() = " + first.get());
        System.out.println("--------------------------------------------------------------------------------------------------");
        Optional<Employee> any = EmployeeData.getEmplees().stream().findAny();
        System.out.println("any.get() = " + any.get());
        System.out.println("--------------------------------------------------------------------------------------------------");
        long count = EmployeeData.getEmplees().stream().count();
        System.out.println("count = " + count);
        System.out.println("--------------------------------------------------------------------------------------------------");
        Optional<Employee> maxSalayEmployee = EmployeeData.getEmplees().stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("maxSalayEmployee.get() = " + maxSalayEmployee.get());
        System.out.println("--------------------------------------------------------------------------------------------------");
        //实体，映射字段 或者其他实体
        Optional<Integer> minAge = EmployeeData.getEmplees().stream().map(Employee::getAge).min(Integer::compare);
        System.out.println("minAge.get() = " + minAge.get());
        System.out.println("--------------------------------------------------------------------------------------------------");
        EmployeeData.getEmplees().forEach(employee -> System.out.println(employee.getName()));
    }

    /**
     * reduce 规约
     */
    @Test
    public void test006() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int reduce = Arrays.stream(ints).reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);
        Optional<Double> sumSalary = EmployeeData.getEmplees().stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println("sumSalary.get() = " + sumSalary.get());
    }

    /**
     * 收集
     * collect
     */
    @Test
    public void test007(){
        List<Employee> employeeList = EmployeeData.getEmplees().stream().filter(employee -> employee.getSalary() > 20).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
    }

    public static Stream<Character> stringToStream(String s) {
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }

        return characterList.stream();
    }

    @Test
    public void test999() {
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

    @Test
    public void test010() throws Exception {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).filter(mersenne -> mersenne.isProbablePrime(50)).limit(20).forEach(System.out::println);
    }

    @Test
    public void test011() throws Exception {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).filter(mersenne -> mersenne.isProbablePrime(Integer.MAX_VALUE)).limit(15).forEach(mp -> System.out.println(mp.bitLength() + ":" + mp));
    }

    static  Stream<BigInteger> primes(){
        return Stream.iterate(TWO,BigInteger::nextProbablePrime);
    }
}
