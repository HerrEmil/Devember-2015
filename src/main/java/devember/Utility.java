package devember;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class Utility {
    private static Utility ourInstance = new Utility();

    public static Utility getInstance() {
        return ourInstance;
    }

    private Utility() {
    }

    public void MoveToElement(WebDriver driver, WebElement element, By locator) {
        if (!(driver instanceof SafariDriver)) {
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String locatorType = locator.toString().substring(3);
            String elem = "var elem = document;";
            if (locatorType.startsWith("id")) {
                elem = "var elem = document.getElementById(\""+locatorType.substring(4)+"\");";
            }
            else if (locatorType.startsWith("xpath")) {
                String snippet = "document.getElementByXPath = function(sValue) { var a = this.evaluate(sValue, this, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0) { return a.snapshotItem(0); } }; ";
                js.executeScript(snippet);
                elem = "var elem = document.getElementByXPath(\""+locatorType.substring(7)+"\");";
            }
            else if (locatorType.startsWith("className")) {
                elem = "var elem = document.getElementsByClassName(\""+locatorType.substring(14)+"\")[0];";
            }
            String mouseOverScript = elem + " if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false);" +
                    " elem.dispatchEvent(evObj);} else if(document.createEventObject) { elem.fireEvent('onmouseover');}";
            js.executeScript(mouseOverScript);
        }
    }
}
