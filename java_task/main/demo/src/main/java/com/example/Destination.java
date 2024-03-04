/**
 * Destination class 
 */
package com.example;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name){
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity){
        if(!activities.contains(activity)){
            activities.add(activity); // add activity only if not added before
        } else {
            System.out.println("Already exists");
        }
    }

    public List<Activity> getAvailableActivities(){ // function to return list of empty activities.
        List<Activity> availableList = new ArrayList<>();
        for (Activity activity : activities) {
            if(activity.isAvailable()){
                availableList.add(activity);
            }
        }
        return availableList;
    }

    public String getName() {
        return name;
    }

    public void printActivities(){
        for (Activity activity : activities) { // print details of each activity
            activity.getDetails();
        }
    }

    public List<Activity> getActivities(){
        return activities;
    }
}
