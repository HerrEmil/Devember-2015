package devember;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {
    public WebDriver driver;

    public Browser() {
        // start the proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure proxy as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
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

        // start the browser up
        driver = new FirefoxDriver(capabilities);
    }
}