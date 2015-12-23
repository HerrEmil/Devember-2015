package devember.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuyOrReserve {
    WebDriver driver;

    public BuyOrReserve(WebDriver driver){
        this.driver = driver;
    }

    public boolean IsAt(){
        return driver.getCurrentUrl().equals("http://www.sf.se/biljetter/bokningsflodet/kop-och-reservera/");
    }

    public String GetSelectedMovie(){
        return driver.findElement(By.cssSelector("#BookingRecieptMovieInfo > h2")).getText();
    }

    public String GetSelectedCinema(){
        List<WebElement> bookingReceiptDivs = driver.findElements(By.cssSelector("ul#BookingRecieptBodyList li.first div"));
        return bookingReceiptDivs.get(bookingReceiptDivs.size() - 1).getText();
    }

    public String GetSelectedDayAndTime(){
        return driver.findElement(By.cssSelector("ul#BookingRecieptBodyList li.first div")).getText();
    }
}
