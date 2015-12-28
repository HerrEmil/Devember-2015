package devember.pageobjects;

import devember.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu {
    WebDriver driver;

    public TopMenu(WebDriver driver){
        this.driver = driver;
    }

    public void SelectCity(String city) throws InterruptedException {
        WebElement chooseCity = driver.findElement(By.id("ChooseCity"));
        chooseCity.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(city)));

        chooseCity.findElement(By.linkText(city)).click();

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().contains("city=");
            }
        });
    }

    public void Tickets() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(By.linkText("BILJETTER"));
        WebElement link = driver.findElement(By.cssSelector("div.subMenuCategoryListContainer > ul > li > a"));

//        actions.moveToElement(hover)
//                .moveToElement(link)
//                .click()
//                .build()
//                .perform();

        Utility utility = new Utility(driver);
        utility.MoveToElement(hover, By.linkText("BILJETTER"));
//        hover.click();
        Thread.sleep(5000);
        utility.MoveToElement(link, By.cssSelector("div.subMenuCategoryListContainer > ul > li > a"));
        System.out.println("before clicking link");
        link.click();
        System.out.println("after clicking link");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals("http://www.sf.se/biljetter/bokningsflodet/valj-forestallning/");
            }
        });
        // TODO: Since I'm waiting for the URL I maybe should just write sf.bookingFlow.GoTo() that driver.get() the URL
    }
}
