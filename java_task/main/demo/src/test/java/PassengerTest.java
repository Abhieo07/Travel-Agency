/**
 * Test Cases for class Passenger
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.*;

public class PassengerTest {

    @Test
    public void testStandardPassengerSignUpForActivity_Success() {
        Passenger passenger = new StandardPassenger("John Doe", "123", 100.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        
        passenger.signUpForActivity(activity);
        
        assertEquals(50.0, passenger.getBalance(), 0.0);
    }

    @Test
    public void testGoldPassengerSignUpForActivity_Success() {
        Passenger passenger = new GoldPassenger("John Doe", "123", 100.0);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        
        passenger.signUpForActivity(activity);
        
        assertEquals(55.0, passenger.getBalance(), 0.0);
    }

    @Test
    public void testPremiumPassengerSignUpForActivity_Success() {
        Passenger passenger = new PremiumPassenger("John Doe", "123");
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10);
        
        passenger.signUpForActivity(activity);
        
        assertEquals(0.0, passenger.getBalance(), 0.0);
    }
}
