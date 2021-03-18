package com.example.training;

import org.junit.Test;

public  class Main {
    @Test
    public void start(){
        Cat cat = new Cat("tom",2);
        cat.getInfo();
        cat.move();

        System.out.println("\n After moving \n");
        cat.getInfo();
    }

    public abstract class Animal {
        private String mName;
        private int mAge;
        private int mSpeed;

        public Animal(String name, int age, int speed) {
            this.mName = name;
            this.mAge = age;
        }

        public void setmSpeed(int speed) {
            this.mSpeed = speed;
        }

        public int getmSpeed() {
            return mSpeed;
        }

        public void getInfo() {
            System.out.println("Name: " + mName + "\nAge: " + mAge + "\nSpeed: " + mSpeed);
        }

        public abstract void move();

    }

    final class Cat extends Animal{

        public Cat(String name, int age){
            super(name,age,0);
        }

        public void move(){
            int speed = getmSpeed();
            speed++;
            setmSpeed(speed);
        }
    }

}
