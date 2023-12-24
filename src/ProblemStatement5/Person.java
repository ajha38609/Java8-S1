package ProblemStatement5;

import java.util.Objects;
public class Person {
	
	
 private int id;
 private String name;
 private int age;
 private double salary;
 public Person(int id, String name, int age, double salary) {
 this.id = id;
 this.name = name;
 this.age = age;
 this.salary = salary;
 }
 public int getId() {
 return id;
 }
 public String getName() {
 return name;
 }
 public int getAge() {
 return age;
 }
 public double getSalary() {
 return salary;
 }
 @Override
 public String toString() {
 return "Person{" +
 "id=" + id +
 ", name='" + name + '\'' +
 ", age=" + age +
 ", salary=" + salary +
 '}';
 }
 @Override
 public int hashCode() {
 return Objects.hash(id);
 }
 @Override
 public boolean equals(Object obj) {
 if (this == obj) return true;
 if (obj == null || getClass() != obj.getClass()) return false;
 Person person = (Person) obj;
 return id == person.id;
 }
}
