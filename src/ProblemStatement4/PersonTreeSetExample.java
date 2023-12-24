package ProblemStatement4;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
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

    // Override compareTo method for natural sorting based on id
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.id, other.id);
    }

    // Override toString method for easy printing
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }

    // Override hashCode and equals methods for proper functioning in TreeSet
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id &&
                age == person.age &&
                Double.compare(person.salary, salary) == 0 &&
                Objects.equals(name, person.name);
    }
}


public class PersonTreeSetExample {

	public static void main(String[] args) {
		//Create a TreeSet of Persons for natural sorting based on id
        Set<Person> personSet = new TreeSet<>();

        // Accept information of 10 persons and store in TreeSet
        for (int i = 1; i <= 10; i++) {
            Person person = new Person(i, "Person" + i, 25 + i, 50000 + i * 1000);
            personSet.add(person);
        }

        // Print all persons details using Method Reference
        personSet.forEach(System.out::println);

	}

}