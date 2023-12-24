package ProblemStatement5;

import java.util.*;
import java.util.stream.Collectors;

public class TestPersonOperation {
 public static void main(String[] args) {
	 
 Set<Person> persons = new HashSet<>();
 
 persons.add(new Person(1, "John", 35, 50000));
 // Add other person details similarly...
 // 1. Print all persons details using Streams and Method Reference
 persons.forEach(System.out::println);
 // 2. Print all persons sorted by ID in ascending order using Comparable and Streams
 persons.stream()
 .sorted()
 .forEach(System.out::println);
 // 3. Print all persons sorted by name in ascending order using Comparator and Streams
 persons.stream()
 .sorted(Comparator.comparing(Person::getName))
 .forEach(System.out::println);
 // 4. Print all persons sorted by names in descending order using Comparator and Streams
 persons.stream()
 .sorted(Comparator.comparing(Person::getName).reversed())
 .forEach(System.out::println);
 // 5. Print all persons whose Name starts with 'J' using Streams
 persons.stream()
 .filter(p -> p.getName().startsWith("J"))
 .forEach(System.out::println);
 // 6. Print the count number of persons using Streams
 long count = persons.stream().count();
 System.out.println("Count: " + count);
 // 7. Print the Max salary among all persons using Streams
 Optional<Double> maxSalary = persons.stream()
 .map(Person::getSalary)
 .max(Double::compareTo);
 maxSalary.ifPresent(s -> System.out.println("Max Salary: " + s));
 
 Optional<Double> minSalary = persons.stream()
 .map(Person::getSalary)
 .min(Double::compareTo);
 minSalary.ifPresent(s -> System.out.println("Min Salary: " + s));
 OptionalDouble averageSalary = persons.stream()
 .mapToDouble(Person::getSalary)
 .average();
 averageSalary.ifPresent(s -> System.out.println("Average Salary: " + s));
 
 double sumSalaries = persons.stream()
 .mapToDouble(Person::getSalary)
 .sum();
 System.out.println("Sum of Salaries: " + sumSalaries);
 Optional<Person> firstPersonWithNameJ = persons.stream()
 .filter(p -> p.getName().startsWith("J"))
 .findFirst();
 firstPersonWithNameJ.ifPresent(System.out::println);
 boolean allAgeGreaterThan10 = persons.stream()
 .allMatch(p -> p.getAge() > 10);
 System.out.println("All persons age > 10: " + allAgeGreaterThan10);
 boolean allAgeGreaterThan50 = persons.stream()
 .noneMatch(p -> p.getAge() > 50);
 System.out.println("All persons age <= 50: " + allAgeGreaterThan50);
 double averageSalaryCollectors = persons.stream()
 .collect(Collectors.averagingDouble(Person::getSalary));
 System.out.println("Average Salary using Collectors: " + averageSalaryCollectors);
 
 Map<Double, List<Person>> personsGroupedBySalary = persons.stream()
 .collect(Collectors.groupingBy(Person::getSalary));
 System.out.println("Persons grouped by salary: " + personsGroupedBySalary);
 long start = System.nanoTime();
 long end = System.nanoTime();
 System.out.println("Time taken with sequential stream: " + (end - start) + " ns");
 
 long startParallel = System.nanoTime();
 long endParallel = System.nanoTime();
 System.out.println("Time taken with parallel stream: " + (endParallel - startParallel) + " ns");
 }
}