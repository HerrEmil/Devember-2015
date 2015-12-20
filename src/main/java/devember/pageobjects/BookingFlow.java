package devember.pageobjects;

import org.openqa.selenium.WebDriver;

public class BookingFlow {
    WebDriver driver;
    public SelectShow selectShow;
    public SelectSeats selectSeats;
    public BuyOrReserve buyOrReserve;

    public BookingFlow(WebDriver driver){
        this.driver = driver;
        this.selectShow = new SelectShow(driver);
        this.selectSeats = new SelectSeats(driver);
        this.buyOrReserve = new BuyOrReserve(driver);
    }
}
