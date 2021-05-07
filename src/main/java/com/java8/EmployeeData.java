package com.java8;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmplees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"雷军",1,16d));
        list.add(new Employee(2,"马化腾",11,14d));
        list.add(new Employee(3,"张磊",111,13d));
        list.add(new Employee(4,"马云",1111,12d));
        list.add(new Employee(5,"吴亚军",1111,111d));
        list.add(new Employee(5,"比尔盖茨",1111,111d));
        list.add(new Employee(5,"扎克伯格",1111,111d));

        return list;
    }
}
