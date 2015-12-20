package devember;

import devember.pageobjects.BookingFlow;
import devember.pageobjects.TopMenu;
import org.openqa.selenium.WebDriver;

public class SF {
    WebDriver driver;
    public TopMenu topMenu;
    public BookingFlow bookingFlow;

    public SF(WebDriver driver){
        this.driver = driver;
        this.topMenu = new TopMenu(driver);
        this.bookingFlow = new BookingFlow(driver);
    }
}
