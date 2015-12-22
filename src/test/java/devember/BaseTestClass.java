package devember;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
    Browser browser = new Browser();
    WebDriver driver = browser.driver;
    SF sf = new SF(driver);

    @BeforeTest
    public void setUp() {
        driver.get("https://www.sf.se/");
        sf.dismissCookieNotice();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}
