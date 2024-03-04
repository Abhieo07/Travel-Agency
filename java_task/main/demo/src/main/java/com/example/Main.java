/**
 * This is an assignment given to Gautam Mandal(myself) by Nymnle
 * 
 * This is the main file to be run inorder to achieve the following:
 *  1. Print itinerary of the travel package including: 
 *       1. travel package name, 
 *       2. destinations and details of the activities available at each destination, like name, cost, capacity and description.
 *   2. Print the passenger list of the travel package including: 
 *       1. package name, 
 *       2. passenger capacity, 
 *       3. number of passengers currently enrolled and 
 *       4. name and number of each passenger
 *   3. Print the details of an individual passenger including their 
 *       1. name, 
 *       2. passenger number, 
 *       3. balance (if applicable), 
 *       4. list of each activity they have signed up for, including the destination the at which the activity is taking place and the price the passenger paid for the activity.
 *   4. Print the details of all the activities that still have spaces available, including how many spaces are available.
 */
package com.example;

import java.util.List;

class printDetails{
    public printDetails(List<Passenger> passengerList){
        System.out.println("__________Passenger List__________");
        for (Passenger passenger : passengerList) {
            System.out.println("Name : "+passenger.getName()+ " Number: "+ passenger.getNumber()+" Balance: "+ passenger.getBalance());
        }
    }

    public printDetails(List<Destination> itnerary, String name){
        System.out.println("Itnerary for "+name+" : ");
        for (Destination destination : itnerary) {
            System.out.println("Activities for destination: "+ destination.getName()+" : ");
            destination.printActivities();
        }
    }

    public printDetails(List<Activity> activities, Passenger passenger){
        System.out.println("Name : "+passenger.getName()+ " Number: "+ passenger.getNumber()+" Balance: "+ passenger.getBalance());
        System.out.println("Activities enrolled: "+ activities.size());
        for (Activity activity : activities) {
            activity.getDetails();
        }
    }

    public printDetails(TravelPackage travelPackage){
        for (Destination destination : travelPackage.getItnerary()) {
            for (Activity activity : destination.getAvailableActivities()) {
                activity.getDetails();
            }
        }
    }

}

public class Main {


    public static void main(String[] args) {
        // Creating a travel package
        TravelPackage travelPackage = new TravelPackage("Europe Tour", 20);

        // Creating destinations
        Destination paris = new Destination("Paris");
        Destination rome = new Destination("Rome");

        // Creating activities for Paris destination
        Activity eiffelTower = new Activity("Visit Eiffel Tower", "Iconic landmark", 20.0, 50);
        Activity louvreMuseum = new Activity("Visit Louvre Museum", "World's largest art museum", 25.0, 40);
        paris.addActivity(eiffelTower);
        paris.addActivity(louvreMuseum);

        // Creating activities for Rome destination
        Activity colosseum = new Activity("Visit Colosseum", "Ancient amphitheater", 30.0, 60);
        Activity vaticanCity = new Activity("Visit Vatican City", "Home of the Pope", 35.0, 50);
        rome.addActivity(colosseum);
        rome.addActivity(vaticanCity);

        // Adding destinations to the travel package itinerary
        travelPackage.addDestination(paris);
        travelPackage.addDestination(rome);

        // Adding passengers to the travel package
        Passenger john = new StandardPassenger("John Doe", "123", 200.0);
        Passenger jane = new GoldPassenger("Jane Smith", "456", 300.0);
        travelPackage.addPassenger(john);
        travelPackage.addPassenger(jane);

        // Task 1: Print itinerary of the travel package
        System.out.println("1. Printing itinerary of the travel package:");
        System.out.println("___________________________________________________");
        new printDetails(travelPackage.getItnerary(), travelPackage.getName());

        // Task 2: Print the passenger list of the travel package
        System.out.println("\n2. Printing passenger list of the travel package:");
        System.out.println("_____________________________________________________");
        new printDetails(travelPackage.getPassengerList());

        // Task 3: Print the details of an individual passenger
        System.out.println("\n3. Printing details of individual passengers:");
        System.out.println("_________________________________________________________");
        new printDetails(john.getSignUpedActiivities(), john);
        new printDetails(jane.getSignUpedActiivities(), jane);

        // Task 4: Print details of activities with available spaces
        System.out.println("\n4. Printing details of activities with available spaces:");
        System.out.println("_____________________________________________________________");
        new printDetails(travelPackage);
    }
}
