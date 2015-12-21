package devember.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSeats {
    WebDriver driver;

    public SelectSeats(WebDriver driver){
        this.driver = driver;
    }

    public void NumberOfAdults(String seats){
        // TODO: Select number of tickets in a way that does not assume the default number is 2
        driver.findElement(By.id("SeatingTicketsContainer")).findElement(By.className("descBtn")).click();
    }

    public void SelectAnyAvailableSeat(){
        System.out.println("SelectAnyAvailableSeat");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src=\"/ClientUI/Images/DvSeatSelector/seats/sm/PA.png\"]")));
        driver.findElement(By.cssSelector("img[src=\"/ClientUI/Images/DvSeatSelector/seats/sm/PA.png\"]")).click();

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                return (Boolean) executor.executeScript("return (window.angular !== undefined) && " +
                        "(angular.element(document.getElementById('ng-app')).injector() !== undefined) && " +
                        "(angular.element(document.getElementById('ng-app')).injector().get('$http').pendingRequests.length === 0);");
            }
        });
    }

    public void ProceedToBuyOrReserve(){
        System.out.println("ProceedToBuyOrReserve");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSeatingPlannerNext")));
        driver.findElement(By.id("btnSeatingPlannerNext")).click();
    }
}
