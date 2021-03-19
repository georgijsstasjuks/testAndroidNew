package com.example.training;
import org.junit.Test;


public class Book implements Printable {

    private String mTitle;
    private String mAuthor;

    public Book() {
        mTitle = "Random title";
        mAuthor = "Random author";
    }

    @Test
    public void print(){
        System.out.println("Title: " + mTitle + "\nAuthor: " + mAuthor);
    }

}
