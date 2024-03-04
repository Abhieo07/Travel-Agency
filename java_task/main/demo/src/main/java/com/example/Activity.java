/**
 * class for Activity
 */
package com.example;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private List<Passenger> passengers;

    public Activity(String name, String description, double cost, int capacity){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public boolean isAvailable(){
        return passengers.size() < capacity;
    }

    public void getDetails(){
        System.out.println("Activity: "+name);
        System.out.println("Description: "+description);
        System.out.println("Cost: "+cost);
        System.out.println("Capacity: "+capacity);
        System.out.println("Availability: "+(capacity - passengers.size()));
    }

    public void signUpPassenger(Passenger passenger){ //add passenger if space available
        if(isAvailable()){
            passengers.add(passenger);
            passenger.signUpActivity(this); //add activity to the list of enrolled activity of passenger
        }else{
            System.out.println("This activity is Full.");
        }
    }

    public double getCost(){
        return cost;
    }

    public List<Passenger> getPassengers(){ //return the list of passengers enrolled for the activity
        return passengers;
    }
}
