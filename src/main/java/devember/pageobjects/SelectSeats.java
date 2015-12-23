package devember.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSeats {
    WebDriver driver;

    public SelectSeats(WebDriver driver){
        this.driver = driver;
    }

    public void NumberOfAdults(String seats) throws InterruptedException {
        // TODO: Select number of tickets in a way that does not assume the default number is 2
        Thread.sleep(1000);
        driver.findElement(By.id("SeatingTicketsContainer")).findElement(By.className("descBtn")).click();
        Thread.sleep(1000);
    }

    public void SelectAnyAvailableSeat() throws InterruptedException {

        Thread.sleep(5000); // TODO: Figure out what exactly I am waiting for on this page before I can click a seat

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src=\"/ClientUI/Images/DvSeatSelector/seats/sm/PA.png\"]")));
        driver.findElement(By.cssSelector("img[src=\"/ClientUI/Images/DvSeatSelector/seats/sm/PA.png\"]")).click();
    }

    public void ProceedToBuyOrReserve() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSeatingPlannerNext")));
        driver.findElement(By.id("btnSeatingPlannerNext")).click();

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals("http://www.sf.se/biljetter/bokningsflodet/kop-och-reservera/");
            }
        });
    }
}
