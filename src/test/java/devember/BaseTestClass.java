package devember;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseTestClass {
    Browser browser;
    WebDriver driver;
    SF sf;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        browser = new Browser();
        driver = browser.driver;
        sf = new SF(driver);
        driver.get("https://www.sf.se/");
        sf.dismissCookieNotice();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}
