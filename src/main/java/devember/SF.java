package devember;

import org.openqa.selenium.WebDriver;

public class SF {
    WebDriver driver;
    TopMenu topMenu;
    BookingFlow bookingFlow;

    public SF(WebDriver driver){
        this.driver = driver;
        this.topMenu = new TopMenu(driver);
        this.bookingFlow = new BookingFlow(driver);
    }
}
