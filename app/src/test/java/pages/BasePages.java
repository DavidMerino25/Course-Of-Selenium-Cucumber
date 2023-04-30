package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

public class BasePages {
    protected static WebDriver driver; //teenmos una variables de tipo protected para que las clases hijas puedan acceder a ella

    private static WebDriverWait wait; //espera explicita


    static{
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); //ruta del driver
        ChromeOptions chromeOptions = new ChromeOptions(); //instanciamos un objeto de tipo ChromeOptions
       
        chromeOptions.addArguments("--remote-allow-origins=*"); //para que no se bloquee el navegador
        chromeOptions.addArguments("user-data-dir=C:/Users/David/AppData/Local/Google/Chrome/User Data"); //para que no se bloquee el navegador
        chromeOptions.addArguments("--disable-notifications"); //para que no se bloquee el navegador
       
        driver = new ChromeDriver(chromeOptions); //instanciamos un objeto de tipo ChromeDriver y le pasamos como parametro el objeto chromeOptions
        
        wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //instanciamos un objeto de tipo WebDriverWait y le pasamos como parametro el objeto driver y el tiempo de espera
    }

    public BasePages(WebDriver driver){  //constructor
        BasePages.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){ //metodo para navegar a una url
        driver.get(url);
    }

    private WebElement findElement(String locator){ //metodo para encontrar un elemento web
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); //retornamos un elemento web
    }

    public void clickElement(String locator){ //metodo para hacer click en un elemento web
        findElement(locator).click();
    }

    public void writeText( String locator, String textToWrite){ //metodo para escribir texto en un elemento web
        findElement(locator).clear(); //limpiamos el elemento web
        findElement(locator).sendKeys(textToWrite); //escribimos en el elemento web
    }

    public void selectDropDownByValue(String locator, String valueToSelect){ //metodo para seleccionar una opcion de un dropdown por valor
        Select dropdown = new Select(findElement(locator)); //instanciamos un objeto de tipo Select y le pasamos como parametro el elemento web
        dropdown.selectByValue(valueToSelect);  // indicamos que la selección será por el valor
    }

    public void selectDropDownByIndex(String locator, int valueToSelect){ //metodo para seleccionar una opcion de un dropdown por Index
        Select dropdown = new Select(findElement(locator)); //instanciamos un objeto de tipo Select y le pasamos como parametro el elemento web
        dropdown.selectByIndex(valueToSelect);  // indicamos que la selección será por el Index
    }

    public void selectDropDownByText(String locator, String valueToSelect){ //metodo para seleccionar una opcion de un dropdown por Index
        Select dropdown = new Select(findElement(locator)); //instanciamos un objeto de tipo Select y le pasamos como parametro el elemento web
        dropdown.selectByVisibleText(valueToSelect);  // indicamos que la selección será por el Index
    }
}

