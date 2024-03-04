package com.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {
    protected String name;
    protected String passengerNumber;
    protected double balance;
    protected List<Activity> signedUpActivities;

    public Passenger(String name, String passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    public abstract void signUpForActivity(Activity activity);

    public void signUpActivity(Activity activity) {
        signedUpActivities.add(activity);
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return passengerNumber;
    }

    public double getBalance(){
        return balance;
    }

    public List<Activity> getSignUpedActiivities(){
        return signedUpActivities;
    }
}


