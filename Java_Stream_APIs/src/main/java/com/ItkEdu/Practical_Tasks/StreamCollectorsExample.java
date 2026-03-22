package com.ItkEdu.Practical_Tasks;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        // Step 1 + 2: Group by product and calculate total cost
        Map<String, Double> totalCostByProduct =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getProduct,
                                Collectors.summingDouble(Order::getCost)
                        ));

        // Step 3 + 4 + 5: Sort, limit top 3
        List<Map.Entry<String, Double>> topProducts =
                totalCostByProduct.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .limit(3)
                        .collect(Collectors.toList());

        // Step 6: Print result
        System.out.println("Top 3 Expensive Products:");
        for (Map.Entry<String, Double> entry : topProducts) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}