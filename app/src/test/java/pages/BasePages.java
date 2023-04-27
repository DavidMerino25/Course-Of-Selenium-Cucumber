package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePages {
    protected static WebDriver driver;

    private static WebDriverWait wait;


    static{
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
       
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("user-data-dir=C:/Users/David/AppData/Local/Google/Chrome/User Data");
        chromeOptions.addArguments("--disable-notifications");
       
       
        driver = new ChromeDriver(chromeOptions);
        
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public BasePages(WebDriver driver){
        BasePages.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }
}
