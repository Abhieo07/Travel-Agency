package com.example;

public  class StandardPassenger extends Passenger {
    public StandardPassenger(String name, String passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    @Override
    public void signUpForActivity(Activity activity) {
        if (balance >= activity.getCost()) {
            balance -= activity.getCost();
            activity.signUpPassenger(this);
        }
    }
}
