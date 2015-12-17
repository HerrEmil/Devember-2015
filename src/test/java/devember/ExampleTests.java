package devember;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ExampleTests {
    Browser myBrowser = new Browser();
    ExamplePage page = new ExamplePage(myBrowser.Driver);

    @Test
    public void simpleExampleTest() {
        Assert.assertTrue(true, "Herp derp");
    }

    @Test
    public void navigateToExampleTest() {
        page.GoTo();
        Assert.assertTrue(page.isAt(), "Could not navigate to example.com");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        myBrowser.Driver.quit();
    }
}
