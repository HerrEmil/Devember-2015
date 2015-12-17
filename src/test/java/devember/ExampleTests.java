package devember;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTests extends TestBase {

    @Test
    public void simpleExampleTest() {
        Assert.assertTrue(true, "Herp derp");
    }

    @Test
    public void navigateToExampleTest() {
        example.GoTo();
        Assert.assertTrue(example.isAt(), "Navigated to example.com");
    }
}
