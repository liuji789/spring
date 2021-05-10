package com.java8;

import java.util.Optional;

import org.junit.Test;

/**
 * @author qingn
 *
 */
public class OptionalTest {
    /**
     * 创建Optional类对象
     * @throws Exception
     */
    @Test
    public void test001() throws Exception {
        Employee employee = null;
        //Optional.of(employee);
        //Optional.empty();
        Optional<Employee> employeeOptional = Optional.ofNullable(employee);
        Employee employee2 = employeeOptional.orElse(new Employee(99999, "default"));
        employeeOptional.ifPresent(employee1 -> System.out.println("employee1.getName() " + employee1.getName()));
        System.out.println("employee2.getName() = " + employee2.getName());
        System.out.println("--------------------------------------------------------------------------------------------------");

        //orElse 当对象为null时给定一个默认值
        Employee employee22 = new Employee(22,"22",22,22d);
        Optional<Employee> employeeOptional22 = Optional.ofNullable(employee22);
        Employee employee222 = employeeOptional22.orElse(new Employee(99999, "default"));
        employeeOptional22.ifPresent(employee1 -> System.out.println("employee1.getName() " + employee1.getName()));
        System.out.println("employee222.getName() = " + employee222.getName());
    }

}
