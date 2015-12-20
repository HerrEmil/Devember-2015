package devember.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectShow {
    WebDriver driver;

    public SelectShow(WebDriver driver){
        this.driver = driver;
    }

    public void SelectDay(String day){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BookingMenuDayContainer")));
        driver.findElement(By.id("BookingMenuDayContainer")).click();

        switch (day.toLowerCase()) {
            case "tomorrow":
                driver.findElement(By.cssSelector("#BookingMenuDay > li:nth-child(3) > a")).click();
                break;
            case "today":
                driver.findElement(By.cssSelector("#BookingMenuDay > li:nth-child(2) > a")).click();
                break;
            case "other":
                driver.findElement(By.id("#AnnanDagLeft")).click();
                break;
            default:
                driver.findElement(By.linkText(day)).click();
        }
    }
}
