package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ali", "Veli"));
        employees.add(new Employee(2, "Ayşe", "Fatma"));
        employees.add(new Employee(1, "Ali", "Veli"));
        employees.add(new Employee(3, "John", "Doe"));
        employees.add(new Employee(2, "Ayşe", "Fatma"));
        employees.add(new Employee(4, "Jane", "Smith"));

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("After removing duplicates: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new HashSet<>();
        for (Employee e : list) {
            if (!seen.add(e)) {
                duplicates.add(e);
            }
        }
        return new ArrayList<>(duplicates);
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Employee, Integer> frequencyMap = new HashMap<>();
        for (Employee e : list) {
            frequencyMap.put(e, frequencyMap.getOrDefault(e, 0) + 1);
        }

        Map<Integer, Employee> uniqueMap = new HashMap<>();
        for (Map.Entry<Employee, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1 || entry.getValue() > 1 && !uniqueMap.containsKey(entry.getKey().getId())) {
                uniqueMap.put(entry.getKey().getId(), entry.getKey());
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> countMap = new HashMap<>();
        for (Employee e : list) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        List<Employee> result = new ArrayList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
