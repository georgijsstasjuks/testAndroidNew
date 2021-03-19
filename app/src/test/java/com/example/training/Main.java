package com.example.training;

import org.junit.Test;

public  class Main {
    @Test
    public void start() {
        Cat cat = new Cat("tom",2);
        cat.getInfo();
        cat.move();

        System.out.println("\n After moving \n");
        cat.getInfo();
    }

    public abstract class Animal {
        private String name;
        private int age;
        private int speed;

        public Animal(String name, int age, int speed) {
            this.name = name;
            this.age = age;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getSpeed() {
            return speed;
        }

        public void getInfo() {
            System.out.println("Name: " + name + "\nAge: " + age + "\nSpeed: " + speed);
        }

        public abstract void move();

    }

    final class Cat extends Animal {

        public Cat(String name, int age){
            super(name,age,0);
        }

        public void move() {
            int speed = getSpeed();
            speed++;
            setSpeed(speed);
        }
    }

}
