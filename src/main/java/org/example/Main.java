package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new LinkedHashSet<>();
        for (Employee emp : employees) {
            if (emp != null) {
                if (!seen.add(emp)) {
                    duplicates.add(emp);
                }
            }
        }
        return new LinkedList<>(duplicates);
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> result = new HashMap<>();

        for (Employee emp : employees) {
            if (emp != null) {
                countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
                result.putIfAbsent(emp.getId(), emp); // sadece ilkini koy
            }
        }
        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> countMap = new HashMap<>();
        for (Employee emp : employees) {
            if (emp != null) {
                countMap.put(emp, countMap.getOrDefault(emp, 0) + 1);
            }
        }

        List<Employee> result = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test için manuel kullanım gerekirse
    }
}
