/**
 * Test Cases for class Activity
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.*;

public class ActivityTest {

    @Test
    public void testIsAvailable_True() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        assertTrue(activity.isAvailable());
    }

    @Test
    public void testIsAvailable_False() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 1);
        activity.signUpPassenger(new StandardPassenger("John Doe", "123", 100.0));
        assertFalse(activity.isAvailable());
    }

    @Test
    public void testSignUpPassenger_Success() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        Passenger passenger = new StandardPassenger("John Doe", "123", 100.0);
        
        activity.signUpPassenger(passenger);
        
        assertEquals(1, activity.getPassengers().size());
    }

    @Test
    public void testSignUpPassenger_Failure() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 1);
        Passenger passenger1 = new StandardPassenger("John Doe", "123", 100.0);
        Passenger passenger2 = new StandardPassenger("Jane Doe", "456", 100.0);
        
        activity.signUpPassenger(passenger1); // Filling the capacity
        activity.signUpPassenger(passenger2); // Trying to sign up another passenger
        
        assertEquals(1, activity.getPassengers().size());
    }

    @Test
    public void testGetCost() {
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        assertEquals(50.0, activity.getCost(), 0.0);
    }
}

