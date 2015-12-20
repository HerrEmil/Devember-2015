package devember.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

        // TODO: This is filthy, replace with wait for page reload
        Thread.sleep(5000);
    }

    public void Tickets(){
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(By.linkText("BILJETTER"));
        WebElement link = driver.findElement(By.cssSelector("div.subMenuCategoryListContainer > ul > li > a"));

        actions.moveToElement(hover)
                .moveToElement(link)
                .click()
                .build()
                .perform();
    }
}
