package devember;

import devember.pageobjects.BookingFlow;
import devember.pageobjects.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("CookiesAreBeingUsedInnerWrapper")));
        driver.findElement(By.id("CookiesAreBeingUsedInnerWrapper")).findElement(By.tagName("a")).click();
    }
}
