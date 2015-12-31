package devember;


import org.openqa.selenium.By;
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
        // If using proxy and IE, we need to handle untrusted certificate notice
        if(driver.findElements(By.id("overridelink")).size() > 0) {
            driver.get("javascript:document.getElementById('overridelink').click();");
        }
        sf.dismissCookieNotice();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        browser.proxy.stop();
        driver.close();
        driver.quit();
    }
}
