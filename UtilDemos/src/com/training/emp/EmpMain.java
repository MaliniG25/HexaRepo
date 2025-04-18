package com.training.emp;

import java.util.ArrayList;

public class EmpMain {
    public static void main(String[] args) {
        ArrayList<Employee> empLoyeeList = new ArrayList<>();
        empLoyeeList.add(new Employee("Malini", 101, "Chennai", 140090));
        empLoyeeList.add(new Employee("Chethu", 102, "Coimbatore", 245800));
        empLoyeeList.add(new Employee("Pandu", 103, "Madurai", 82060));
        empLoyeeList.add(new Employee("Sonu", 104, "Hyderabad", 415400));
        empLoyeeList.add(new Employee("Ganga", 105, "Thiruthani", 1430));

        for (Employee employee : empLoyeeList) {
            System.out.println(employee);
        }
    }
}