package devember;


import org.openqa.selenium.WebDriver;

public class ExamplePage {
    private WebDriver driver;

    public ExamplePage(WebDriver driver){
        this.driver = driver;
    }

    public void GoTo(){
        driver.get("http://example.com/");
    }

    public boolean isAt(){
        return driver.getTitle().equals("Example Domain");
    }


}
