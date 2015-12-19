package devember;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenu {
    WebDriver driver;

    public TopMenu(WebDriver driver){
        this.driver = driver;
    }

    public void SelectCity(String city){
        WebElement chooseCity = driver.findElement(By.id("ChooseCity"));
        chooseCity.click();
        chooseCity.findElement(By.linkText(city)).click();
    }
}
