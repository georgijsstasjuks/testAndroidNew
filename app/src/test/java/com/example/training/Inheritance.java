package com.example.training;
import org.junit.Test;

public class Inheritance {

    @Test
    public void start() {
        Employee sam = new Employee("Sam", "Microsoft");
        sam.display();
    }

    class Person {

        private String name;
        public String getName() { return name; }

        public Person(String name) {
            this.name=name;
        }

        public void display() {
            System.out.println("Name: " + name);
        }
    }

   final class Employee extends Person {

        private String company;

        public Employee(String name, String company) {
            super(name);
            this.company=company;
        }

        @Override
        public void display() {
            System.out.println("Name: " +  getName() );
            System.out.println("Works in:" + company);
        }
    }

}
