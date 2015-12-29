package devember;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class Utility {
    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    public void MoveToElement(WebElement element, By locator) {
        if (!(driver instanceof SafariDriver)) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        }
        else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String locatorType = locator.toString().substring(3);
            String elem = "";
            if (locatorType.startsWith("id")) {
                // TODO: test that move to id works
                elem = "var elem = document.getElementById(\""+locatorType.substring(4)+"\");";
            }
            else if (locatorType.startsWith("xpath")) {
                // TODO: test that move to xpath works
                String snippet = "document.getElementByXPath = function(sValue) { var a = this.evaluate(sValue, this, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0) { return a.snapshotItem(0); } }; ";
                js.executeScript(snippet);
                elem = "var elem = document.getElementByXPath(\""+locatorType.substring(7)+"\");";
            }
            else if (locatorType.startsWith("className")) {
                // TODO: test that move to className works
                elem = "var elem = document.getElementsByClassName(\""+locatorType.substring(14)+"\")[0];";
            }
            else if (locatorType.startsWith("linkText")){
                // JS doesn't have a handy function for getting link element by its text
                // TODO: Try :contains css pseudo selector together with document.querySelector()
                elem = "var aTags = document.getElementsByTagName('a'), elem;" +
                        "for (var i = 0; i < aTags.length; i++) {" +
                        "console.log('aTags[i]: ' + aTags[i]);" +
                        "  if (aTags[i].textContent == '" + locatorType.substring(10) + "') {" +
                        "    elem = aTags[i];" +
                        "    break;}}";
            }
            else if (locatorType.startsWith("cssSelector")){
                elem = "var elem = document.querySelector('" + locatorType.substring(13) + "');";
            }
            String mouseOverScript = elem + "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false);" +
                    " elem.dispatchEvent(evObj);} else if(document.createEventObject) { elem.fireEvent('onmouseover');}";
            js.executeScript(mouseOverScript);
        }
    }
}