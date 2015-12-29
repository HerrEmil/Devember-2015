package devember.pageobjects;

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

    // This and any other functions to interact with :hover menus cannot be used in checks that should be ran in Safari
    // The menu uses :hover CSS to display sub-menus, and it is not possible to trigger :hover from javascript
    // Since the function could never be used in Safari, it may as well use the Actions class
    public void Tickets() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(By.linkText("BILJETTER"));
        WebElement link = driver.findElement(By.cssSelector("div.subMenuCategoryListContainer > ul > li > a"));

        actions.moveToElement(hover)
                .moveToElement(link)
                .click()
                .build()
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals("http://www.sf.se/biljetter/bokningsflodet/valj-forestallning/");
            }
        });
    }
}
