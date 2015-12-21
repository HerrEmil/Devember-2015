package devember.pageobjects;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectShow {
    WebDriver driver;

    public SelectShow(WebDriver driver){
        this.driver = driver;
    }

    public void SelectDay(String day){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BookingMenuDayContainer")));
        driver.findElement(By.id("BookingMenuDayContainer")).click();

        switch (day.toLowerCase()) {
            case "today":
                driver.findElement(By.cssSelector("#BookingMenuDay > li:nth-child(2) > a")).click();
                break;
            case "tomorrow":
                driver.findElement(By.cssSelector("#BookingMenuDay > li:nth-child(3) > a")).click();
                break;
            case "other":
                driver.findElement(By.id("#AnnanDagLeft")).click();
                break;
            default:
                driver.findElement(By.linkText(day)).click();
        }
    }

    public void SelectCinema(String cinema){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BookingTheatreContainer")));
        driver.findElement(By.id("BookingTheatreContainer")).click();

        driver.findElement(By.linkText(cinema)).click();
    }

    public void SelectFirstMovie(String movie){
        String firstMovie = "ul#BookingList li:not(.displayNone)";

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstMovie)));
        driver.findElement(By.cssSelector(firstMovie)).findElement(By.cssSelector("div.mTitle")).click();
    }

    public void SelectShowing(String time){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cmil_time")));

        // Get list of showings
        List<WebElement> timeDivs = driver.findElements(By.cssSelector("div.cmil_time"));

        // In list of showings, find row with matching time
        for(WebElement timeDiv : timeDivs){
            if (timeDiv.getText().contains(time)){
                timeDiv.findElement(By.xpath("..")).findElement(By.cssSelector("div.cmil_btn > a")).click();
                return;
            }
        }
        System.out.println("Could not find showing"); // TODO: find suitable assertion
    }
}
