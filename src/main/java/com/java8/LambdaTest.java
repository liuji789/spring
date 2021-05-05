package com.java8;


import com.example.jvm.clazz.LambdaGC;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author admin
 * -> lambda操作符，左边是lambda形参列表（接口中的抽象方法的形参列表），右边是lambda体（重写的抽象方法的方法体）
 */
public class LambdaTest {

    /**
     * 无参无返回值
     */
    @Test
    public void test001() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("this is java7");
            }
        };
        runnable.run();

        Runnable runnable1 = () -> {
            System.out.println("this is java8 no par no return");
        };
        runnable1.run();

        Runnable runnable2 = () -> System.out.println("this is java8 no par no return for one code");

        runnable2.run();
    }


    /**
     * 有一个参数无返回值
     */
    @Test
    public void test002() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("谎言与誓言的却别是什:" + s);
            }
        };
        consumer.accept("没区别");

        //类型推断
        Consumer<String> consumer1 = (s) -> System.out.println("谎言与誓言的却别是什:" + s);
        int[] arr = {1, 2, 3};
        System.out.println("arr = " + arr);

        consumer1.accept("好多区别的!");

        Consumer<String> consumer2 = (String s) -> {
            System.out.println("谎言与誓言的却别是什:" + s);
        };
        consumer2.accept("没有参数类型也可以！");

        Consumer<String> consumer3 = s -> System.out.println("谎言与誓言的却别是什:" + s);

        consumer3.accept("单个参数可以省略小括号，单条语句可以省略大括号");
    }

    @Test
    public void test003() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("comparator.compare(1,2) = " + comparator.compare(1, 2));

        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println("o1 = " + o1);
            System.out.println("o2 = " + o2);
            return o1.compareTo(o2);
        };

        System.out.println("comparator1.compare(2,2) = " + comparator1.compare(2, 2));

        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println("comparator2.compare(3,2) = " + comparator2.compare(3, 2));

        OneMethodInterface oneMethodInterface = () -> System.out.println(Arrays.toString(this.getClass().getMethods()));

        oneMethodInterface.get();

    }


    /**
     * @see Consumer 消费型接口
     * @see java.util.function.Supplier 供给型接口
     * @see java.util.function.Function 函数型接口
     * @see java.util.function.Predicate 断定型接口
     */
    @Test
    public void test004() {

        happyTime(1, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("integer = " + integer);
            }
        });

        happyTime(2, money -> System.out.println("money = " + money));
    }

    public void happyTime(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test005(){
        List<String> jingList = Arrays.asList("北京","天津","南京","东京","西晋");
        System.out.println("filterString:" + filterString(jingList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        }));

        System.out.println("filterString by lambda:" + filterString(jingList, s -> s.contains("京")));
    }

    public List<String> filterString(List<String> oriStrings, Predicate<String> filter){
        List<String> filterAfter = new ArrayList<>();
        for (String oriString : oriStrings) {
            if (filter.test(oriString)){
                filterAfter.add(oriString);
            }
        }
        return filterAfter;
    }
}
