package devember.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectShow {
    WebDriver driver;
    String selectedMovie = "";
    String selectedShowing = "";

    public SelectShow(WebDriver driver){
        this.driver = driver;
    }

    public void GoTo(){
        driver.get("http://www.sf.se/biljetter/bokningsflodet/valj-forestallning/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getPageSource().contains("VÄLJ FILM OCH FÖRESTÄLLNING");
            }
        });
    }

    public void SelectDay(String day) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("BookingMenuDayContainer")));
        driver.findElement(By.id("BookingMenuDayContainer")).findElement(By.className("customSelectBoxHead")).click();

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

    // TODO: Figure out if I can make a SelectCinema function that works with ads blocked
    public void SelectCinema(String cinema){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BookingTheatreContainer")));
        driver.findElement(By.id("BookingTheatreContainer")).click();

        driver.findElement(By.linkText(cinema)).click();
    }

    public void SelectFirstMovie(){
        String firstMovieLI = "ul#BookingList li:not(.displayNone)";

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstMovieLI)));

        selectedMovie = driver.findElement(By.cssSelector(firstMovieLI)).findElement(By.cssSelector(".concept-splash span")).getText();

        driver.findElement(By.cssSelector(firstMovieLI)).findElement(By.cssSelector("div.mTitle")).click();
    }

    public String SelectedMovie(){
        return selectedMovie;
    }

    public void SelectFirstShowing(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cmil_time")));

        WebElement timeDiv = driver.findElement(By.cssSelector("div.cmil_time"));
        selectedShowing = timeDiv.getText();
        timeDiv.findElement(By.xpath("..")).findElement(By.cssSelector("div.cmil_btn > a")).click();
    }

    public String SelectedShowing() {
        return selectedShowing;
    }
}
