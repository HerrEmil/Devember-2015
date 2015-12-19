package devember;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseTestClass {
    Browser browser = new Browser();
    WebDriver driver = browser.Driver;
    ExamplePage example = new ExamplePage(driver);
    SF sf = new SF(driver);

    @AfterSuite
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}
