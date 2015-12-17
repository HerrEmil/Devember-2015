package devember;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample extends BaseTestClass {

    @Test
    public void simpleExample() {
        Assert.assertTrue(true, "Herp derp");
    }

    @Test
    public void navigateToExample() {
        example.GoTo();
        Assert.assertTrue(example.isAt(), "Navigated to example.com");
    }
}
