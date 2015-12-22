package devember;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSF extends BaseTestClass {

    @Test
    public void canGoThroughBookingFlowToPurchase() throws InterruptedException {
        sf.topMenu.SelectCity("Malmö"); // This step would not be needed if showing selections were not hardcoded
        sf.topMenu.Tickets();
        Thread.sleep(5000); //TODO: Wait for page reload
        sf.bookingFlow.selectShow.SelectDay("tomorrow"); // Should be enumeration instead of string
        sf.bookingFlow.selectShow.SelectCinema("Royal"); // This functionality is broken if ads are blocked(!)
        sf.bookingFlow.selectShow.SelectFirstMovie();
        sf.bookingFlow.selectShow.SelectShowing("21:30"); // TODO: works on buy button but not on buy/reserve button

//        sf.bookingFlow.selectSeats.NumberOfAdults("1");
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
