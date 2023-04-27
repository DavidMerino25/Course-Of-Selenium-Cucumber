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
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        
    }
}
