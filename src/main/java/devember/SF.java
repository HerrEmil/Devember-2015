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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CookiesAreBeingUsed")));
        WebElement cookieNotice = driver.findElement(By.id("CookiesAreBeingUsed"));

        // On Safari and Edge, we cannot assume that the cookie notice is displayed so we check
        if(cookieNotice.getAttribute("style") != null && cookieNotice.getAttribute("style").contains("display: block;")){
            wait.until(ExpectedConditions.elementToBeClickable(By.id("CookiesAreBeingUsedInnerWrapper")));
            driver.findElement(By.id("CookiesAreBeingUsedInnerWrapper")).findElement(By.tagName("a")).click();
        }
    }
}
