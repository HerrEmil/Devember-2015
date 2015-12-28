package devember;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browser {
    public WebDriver driver;

    public Browser() throws MalformedURLException {
        // start the proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure proxy as a desired capability
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // Blocking these servers removes most ads, but not the popover (though its images are blocked)
        proxy.blacklistRequests(".*cdn.adnxs.com.*", 400);
        proxy.blacklistRequests(".*cdn.castaclip.net.*", 400);
        proxy.blacklistRequests(".*content.quantcount.com.*", 400);
        proxy.blacklistRequests(".*de17a.com.*", 400);
        proxy.blacklistRequests(".*fw.adsafeprotected.com.*", 400);
        proxy.blacklistRequests(".*ib.adnxs.com.*", 400);
        proxy.blacklistRequests(".*js-agent.newrelic.com.*", 400);
        proxy.blacklistRequests(".*googlesyndication.com.*", 400);
        proxy.blacklistRequests(".*panel2.research-int.se.*", 400);
        proxy.blacklistRequests(".*adform.net.*", 400);
        proxy.blacklistRequests(".*sifomedia.sf.se.*", 400);
        proxy.blacklistRequests(".*google-analyticts.com.*", 400);
        proxy.blacklistRequests(".*z.motads.com.*", 400);
        proxy.blacklistRequests(".*ad.doubleclick.net.*", 400);
        proxy.blacklistRequests(".*rubiconproject.com.*", 400);
        proxy.blacklistRequests(".*adserver.adtechus.com.*", 400);
        proxy.blacklistRequests(".*adtomafusion.com.*", 400);

        // Blocking this blocks the popover, but also breaks other things like the cinema movie filter
//        proxy.blacklistRequests(".*fusion\\.sf\\.se\\/scriptSF\\.js\\?ads=sf", 400);
        proxy.blacklistRequests(".*ads=sf", 400);

        // If using Chrome, the seat picker defaults to a flash player
        // We disable flash to fall back to HTML seat picker
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-bundled-ppapi-flash");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("plugin.state.flash", 0);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);

        capabilities.setCapability("platform", "Windows 10");

        String USERNAME = "HerrEmil";
        String ACCESS_KEY = "PASTE ACCESS KEY HERE"; //TODO: put credentials in separate file and gitignore it
        String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

        System.setProperty("webdriver.ie.driver", "C:\\WebDrivers\\IEDriverServer.exe");
        driver = new SafariDriver(capabilities);

//        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
//        driver = new ChromeDriver(capabilities);

        // start the browser up
//         driver = new RemoteWebDriver(new URL(URL), capabilities);
    }
}