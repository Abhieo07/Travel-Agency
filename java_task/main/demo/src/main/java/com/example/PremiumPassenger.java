package com.example;


public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, String passengerNumber) {
        super(name, passengerNumber, 0);
    }

    @Override
    public void signUpForActivity(Activity activity) {
        activity.signUpPassenger(this);
    }
}
