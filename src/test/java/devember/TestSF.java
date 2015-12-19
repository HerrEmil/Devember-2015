package devember;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSF extends BaseTestClass {

    @BeforeTest
    public void setUp(){
        driver.get("https://www.sf.se/");
        sf.topMenu.SelectCity("Malmö");
    }

//    @Test
//    public void canBookTicket(){
//        sf.topMenu.Tickets();
//        sf.bookingFlow.selectShow.SelectDay("tomorrow");
//        sf.bookingFlow.selectShow.SelectCinema("Royal");
//        sf.bookingFlow.selectShow.SelectMovie("Star Wars: The Force Awakens");
//        sf.bookingFlow.selectShow.SelectShowing("21:30");
//
//        sf.bookingFlow.selectSeats.NumberOfTickets(1);
//        sf.bookingFlow.selectSeats.SelectAnySeat();
//        sf.bookingFlow.selectSeats.ProceedToBuyOrReserve();
//
//    }
}
