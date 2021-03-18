package com.example.training;
import org.junit.Test;


public class Inheritance {

    @Test
    public void start(){
        Employee sam = new Employee("Sam", "Microsoft");
        sam.display();
    }

    class Person {

        private String mName;
        public String getName(){ return mName; }

        public Person(String name){

            this.mName=name;
        }

        public void display(){

            System.out.println("Name: " + mName);
        }
    }

   final class Employee extends Person{

        private String mCompany;

        public Employee(String name, String company) {

            super(name);
            this.mCompany=company;
        }
        @Override
        public void display(){

            System.out.println("Name: " +  getName());
            System.out.println("Works in:" + mCompany);
        }
    }




}
