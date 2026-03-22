# 🚀 Stream API – Order Processing Project

## 📌 Overview

This project demonstrates how to use the **Java Stream API and Collectors** to process a list of orders.
Each order contains a product name and its cost. The goal is to perform real-world data processing operations like grouping, aggregation, sorting, and selecting top results.

---

## 🛠️ Tech Stack

* Java 17
* Apache Maven
* Java Stream API
* Collectors Framework

---

## 📁 Project Structure

```text
StreamOrdersProject/
│
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── com/ItkEdu/streamorders/
│               ├── Order.java
│               └── StreamCollectorsExample.java
```

---

## 🎯 Problem Statement

Given a list of orders:

* Each order has a **product** and a **cost**

Perform the following operations:

1. Group orders by product
2. Calculate total cost per product
3. Sort products by total cost (descending)
4. Select top 3 most expensive products
5. Display the result

---

## 🧠 Concepts Used

* Stream API (`stream()`)
* Collectors (`groupingBy`, `summingDouble`)
* Method references (`Order::getProduct`)
* Lambda expressions
* Sorting with `Comparator`
* Functional programming in Java

---

## 🚀 How It Works

### Step 1: Group and Sum

```java
Map<String, Double> totalCostByProduct =
    orders.stream()
          .collect(Collectors.groupingBy(
              Order::getProduct,
              Collectors.summingDouble(Order::getCost)
          ));
```

👉 Output:

```text
{Laptop=2700.0, Smartphone=1700.0, Tablet=500.0}
```

---

### Step 2: Sort and Get Top 3

```java
List<Map.Entry<String, Double>> topProducts =
    totalCostByProduct.entrySet()
                      .stream()
                      .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                      .limit(3)
                      .collect(Collectors.toList());
```

---

## 📄 Example Input

```java
List<Order> orders = List.of(
    new Order("Laptop", 1200.0),
    new Order("Smartphone", 800.0),
    new Order("Laptop", 1500.0),
    new Order("Tablet", 500.0),
    new Order("Smartphone", 900.0)
);
```

---

## ✅ Output

```text
Top 3 Expensive Products:
Laptop → 2700.0
Smartphone → 1700.0
Tablet → 500.0
```

---

## ▶️ How to Run

### 1. Compile

```bash
mvn clean compile
```

### 2. Run

```bash
mvn exec:java -Dexec.mainClass="com.ItkEdu.streamorders.StreamCollectorsExample"
```

---

## 💼 Learning Outcome

* Applied Stream API to solve real-world data problems
* Learned grouping and aggregation using collectors
* Practiced sorting and limiting results
* Understood functional programming concepts in Java

---

## 📈 Future Improvements

* Add more complex datasets
* Implement using custom objects (DTOs)
* Add unit tests (JUnit)
* Convert to REST API using Spring Boot

---

## 🧑‍💻 Author

**Anop Singh**

---

## ⭐ Support

If you found this useful, give it a ⭐ and feel free to fork and improve!
