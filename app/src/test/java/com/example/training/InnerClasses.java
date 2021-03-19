package com.example.training;
import org.junit.Test;

public class innerClasses {

    @Test
    public void start(){
        Person person = new Person(1, "anon", "John", "Smith");
        person.showInfo();
        person.showAccount();
    }

}

class Person{

    private String mUsername;
    private int mId;
    private AdditionalInfo mAccount;

    Person(int id, String username,  String firstName, String lastName){
        this.mId = id;
        this.mUsername = username;
        mAccount = new AdditionalInfo(firstName, lastName);
    }

    public void showInfo(){
        System.out.println("User id: " + mId + "\n" + "User name: " + mUsername + "\n");
    }

    public void showAccount(){
        System.out.println("First name: " + mAccount.getFirstName() + "\n" + "Last name: " + mAccount.getLastName());
    }

    public class AdditionalInfo{
        private String mFirstName;
        private String mLastName;

        AdditionalInfo(String firstName, String lastName){
            this.mFirstName = firstName;
            this.mLastName = lastName;
        }
        public String getFirstName(){
            return mFirstName;
        }

        public String getLastName(){
            return mLastName;
        }
    }
}