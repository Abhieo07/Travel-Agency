/**
 * Test Cases for class TravelPackage
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.*;

public class TravelPackageTest {
    private TravelPackage travelPackage;
    private StandardPassenger standardPassenger;
    private GoldPassenger goldPassenger;
    private PremiumPassenger premiumPassenger;

    @BeforeEach
    public void setUp() {
        travelPackage = new TravelPackage("Test Travel Package", 3);
        standardPassenger = new StandardPassenger("John", "123", 100);
        goldPassenger = new GoldPassenger("Alice", "456", 200);
        premiumPassenger = new PremiumPassenger("Bob", "789");
    }
    
    @Test
    public void testAddPassenger_Success() {
        travelPackage.addPassenger(standardPassenger);
        travelPackage.addPassenger(goldPassenger);
        travelPackage.addPassenger(premiumPassenger);
        assertEquals(3, travelPackage.getPassengerList().size());
    }

    @Test
    public void testAddPassenger_exceptionThrow() {
        travelPackage.addPassenger(standardPassenger);
        travelPackage.addPassenger(goldPassenger);
        travelPackage.addPassenger(premiumPassenger);
        Passenger extraPassenger = new StandardPassenger("Extra", "999", 50);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> travelPackage.addPassenger(extraPassenger));
        assertTrue(exception.getMessage().contains("The travel package is full."));
    }


    @Test
    public void testSignUpForActivity() {
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 50, 10);
        destination1.addActivity(activity1);
        travelPackage.addDestination(destination1);

        travelPackage.addPassenger(standardPassenger);
        standardPassenger.signUpForActivity(activity1);
        assertTrue(activity1.getPassengers().contains(standardPassenger)); // Check if passenger is signed up for activity
    }

    @Test
    public void testPrintSignedUpActivities() {
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 50, 10);
        destination1.addActivity(activity1);
        travelPackage.addDestination(destination1);

        travelPackage.addPassenger(standardPassenger);
        standardPassenger.signUpForActivity(activity1);
        assertEquals(1,standardPassenger.getSignUpedActiivities().size()); // Check if signed up activities are printed correctly
    }
    
}


