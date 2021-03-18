package com.example.training;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void javaTest(){
        int first = 5;
        int second = 10;

        mathTest math = new mathTest(first, second);
        System.out.println("Answer: " + math.sum());
    }

}

class mathTest{

    private int firstNumber;
    private int secondNumber;

    public mathTest(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int sum(){
        return firstNumber + secondNumber;
    }

}