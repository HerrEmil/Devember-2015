package devember;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    public WebDriver Driver;

    public Browser() {
        Driver = new FirefoxDriver();
    }
}