package devember;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class TestBase {
    Browser browser = new Browser();
    WebDriver driver = browser.Driver;
    ExamplePage example = new ExamplePage(driver);

    @AfterSuite
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}
