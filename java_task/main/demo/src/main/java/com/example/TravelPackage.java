/**
 * Travel Pacjage class 
 */
package com.example;

import java.util.ArrayList;
import java.util.List;


public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itnerary;
    private List<Passenger> passengerList;

    public TravelPackage(String name, int passengerCapacity){
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itnerary = new ArrayList<>();
        this.passengerList = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger){
        if(passengerList.size() < passengerCapacity){
            passengerList.add(passenger);
        }
        else  throw new IllegalArgumentException("The travel package is full. No more passengers can be added.");
    }
    public void addDestination(Destination destination) {
        itnerary.add(destination);
    }

    public List<Passenger> getPassengerList(){
        return passengerList;
    }

    public String getName(){
        return name;
    }

    public List<Destination> getItnerary(){
        return itnerary;
    }
}
