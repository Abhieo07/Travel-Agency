/**
 * Test Cases for class Destination
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.*;

public class DestinationTest {

    @Test
    public void testAddActivity_Success() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        
        destination.addActivity(activity);
        
        assertEquals(1, destination.getActivities().size());
    }

    @Test
    public void testAddMultipleActivities_Success() {
        Destination destination = new Destination("Test Destination");
        Activity activity1 = new Activity("Test Activity 1", "Description 1", 50.0, 10);
        Activity activity2 = new Activity("Test Activity 2", "Description 2", 60.0, 15);
        
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        
        assertEquals(2, destination.getActivities().size());
    }

    @Test
    public void testAddDuplicateActivity_Failure() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        
        destination.addActivity(activity);
        destination.addActivity(activity); // Adding the same activity again
        
        assertEquals(1, destination.getActivities().size());
    }
    @Test
    public void testGetAvailableActivity_WithAvailableActivities() {
        Destination destination = new Destination("Test Destination");
        Activity activity1 = new Activity("Test Activity 1", "Description 1", 50.0, 10);
        Activity activity2 = new Activity("Test Activity 2", "Description 2", 60.0, 15);
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        
        assertEquals(2, destination.getAvailableActivities().size());
    }

    @Test
    public void testGetAvailableActivity_NoAvailableActivities() {
        Destination destination = new Destination("Test Destination");
        Activity activity1 = new Activity("Test Activity 1", "Description 1", 50.0, 0); // Full capacity
        Activity activity2 = new Activity("Test Activity 2", "Description 2", 60.0, 0); // Full capacity
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        
        assertEquals(0, destination.getAvailableActivities().size());
    }

}
