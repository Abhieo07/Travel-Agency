package com.example;

public class GoldPassenger extends Passenger {
    public GoldPassenger(String name, String passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    @Override
    public void signUpForActivity(Activity activity) {
        double discountedCost = activity.getCost() * 0.9;
        if (balance >= discountedCost) {
            balance -= discountedCost;
            activity.signUpPassenger(this);
        }
    }
}
