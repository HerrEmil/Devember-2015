package devember;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSF extends BaseTestClass {

    @Test
    public void canGoThroughBookingFlowToPurchase() throws InterruptedException {
        sf.bookingFlow.selectShow.GoTo();
        sf.bookingFlow.selectShow.SelectDay("tomorrow"); // TODO: Should be enumeration instead of string
        sf.bookingFlow.selectShow.SelectFirstMovie();
        sf.bookingFlow.selectShow.SelectFirstShowing();

        sf.bookingFlow.selectSeats.NumberOfAdults("1"); // TODO: this function discards input and always decreases by 1
        sf.bookingFlow.selectSeats.SelectAnyAvailableSeat();
        sf.bookingFlow.selectSeats.ProceedToBuyOrReserve();

        Assert.assertTrue(sf.bookingFlow.buyOrReserve.IsAt(),
                "Could navigate through booking flow to Purchase/Reserve step");

        Assert.assertEquals(sf.bookingFlow.buyOrReserve.GetSelectedMovie(), sf.bookingFlow.selectShow.SelectedMovie(),
                "Selected movie is seen in Purchase/Reserve step");

        Assert.assertTrue(sf.bookingFlow.buyOrReserve.GetSelectedDayAndTime().contains("Imorgon"),
                "Selected day is seen in Purchase/Reserve step");

        Assert.assertTrue(sf.bookingFlow.buyOrReserve.GetSelectedDayAndTime().contains(sf.bookingFlow.selectShow.SelectedShowing()),
                "Selected showing is seen in Purchase/Reserve step");

        // TODO: This test should continue beyond this step of the booking flow
        // Stopping here until movie selection is not hard coded
        // Currently chosen movie can never be reserved
    }
}
