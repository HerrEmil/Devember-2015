package devember;

import devember.pageobjects.BookingFlow;
import devember.pageobjects.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SF {
    WebDriver driver;
    public TopMenu topMenu;
    public BookingFlow bookingFlow;

    public SF(WebDriver driver){
        this.driver = driver;
        this.topMenu = new TopMenu(driver);
        this.bookingFlow = new BookingFlow(driver);
    }

    public void dismissCookieNotice(){
        if(!driver.findElements(By.id("CookiesAreBeingUsedInnerWrapper")).isEmpty()){
            driver.findElement(By.id("CookiesAreBeingUsedInnerWrapper")).findElement(By.tagName("a")).click();
        }
    }
}
