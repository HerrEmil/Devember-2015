package devember;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSF extends BaseTestClass {

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver.get("https://www.sf.se/");
        Thread.sleep(15000); // TODO: handle popover
        sf.topMenu.SelectCity("Malmö"); // This step would not be needed if showing selections were not hardcoded
        Thread.sleep(10000); // TODO: handle shitty popover
    }

    @Test
    public void canGoThroughBookingFlowToPurchase() throws InterruptedException {
        sf.topMenu.Tickets();
        Thread.sleep(5000); //TODO: Wait for page reload
        sf.bookingFlow.selectShow.SelectDay("tomorrow"); // Should be enumeration instead of string
        sf.bookingFlow.selectShow.SelectCinema("Royal"); // Should have option to select any available option
        sf.bookingFlow.selectShow.SelectFirstMovie("Star Wars"); // Should have option to select any available option
        sf.bookingFlow.selectShow.SelectShowing("21:30"); // Should have option to select any available option

        sf.bookingFlow.selectSeats.NumberOfAdults("1");
//        sf.bookingFlow.selectSeats.SelectAnyAvailableSeat();
//        sf.bookingFlow.selectSeats.ProceedToBuyOrReserve();
//
//        Assert.assertEquals(sf.bookingFlow.buyOrReserve.GetSelectedMovie(), "Star Wars: The Force Awakens",
//                "Selected movie is seen in Purchase/Reserve step");
//
//        Assert.assertEquals(sf.bookingFlow.buyOrReserve.GetSelectedCinema(), "Royal",
//                "Selected cinema is seen in Purchase/Reserve step");
//
//        Assert.assertTrue(sf.bookingFlow.buyOrReserve.GetSelectedDayAndTime().contains("Imorgon"),
//                "Selected day is seen in Purchase/Reserve step");
//
//        Assert.assertEquals(sf.bookingFlow.buyOrReserve.GetSelectedDayAndTime().contains("21:30"),
//                "Selected showing is seen in Purchase/Reserve step");

        // This test should continue beyond this step of the booking flow
        // Stopping here until movie selection is not hard coded
        // Currently chosen movie can never be reserved
    }
}
