package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.Actions;

public class BasePages {
    protected static WebDriver driver; //teenmos una variables de tipo protected para que las clases hijas puedan acceder a ella

    private static WebDriverWait wait; //espera explicita

    private static Actions actions;//acciones


    static{
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); //ruta del driver
        ChromeOptions chromeOptions = new ChromeOptions(); //instanciamos un objeto de tipo ChromeOptions
        chromeOptions.addArguments("--remote-allow-origins=*"); //para que no se bloquee el navegador
        chromeOptions.addArguments("user-data-dir=C:/Users/David/AppData/Local/Google/Chrome/User Data"); //para que no se bloquee el navegador
        chromeOptions.addArguments("--disable-notifications"); //para que no se bloquee el navegador
       
        driver = new ChromeDriver(chromeOptions); //instanciamos un objeto de tipo ChromeDriver y le pasamos como parametro el objeto chromeOptions
        // Esto es de manera explicta para que el navegador no se bloquee
        wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //instanciamos un objeto de tipo WebDriverWait y le pasamos como parametro el objeto driver y el tiempo de espera
        // De mandra implicita (no es recomendable porque puede afectar el rendimiento del navegador)
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //instanciamos un objeto de tipo WebDriverWait y le pasamos como parametro el objeto driver y el tiempo de espera

    }

    public BasePages(WebDriver driver){  //constructor
        BasePages.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //instanciamos un objeto de tipo WebDriverWait y le pasamos como parametro el objeto driver y el tiempo de espera
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

    public void hoverOverElement(String locator){ //metodo para hacer hover sobre un elemento web
      actions.moveToElement(findElement(locator)); //instanciamos un objeto de tipo Actions y le pasamos como parametro el elemento web
    }

    public void doubleClick( String locator){ //metodo para hacer doble click sobre un elemento web
        actions.doubleClick(findElement(locator)); //instanciamos un objeto de tipo Actions y le pasamos como parametro el elemento web
    }
    public void rightClick( String locator){ //metodo para hacer click derecho sobre un elemento web
        actions.contextClick(findElement(locator)); //instanciamos un objeto de tipo Actions y le pasamos como parametro el elemento web    
    }
    //Metodods par buscar una celda en una tabla
    private WebElement cellFinder(String locator, int row, int col) { //metodo para buscar una celda en una tabla
        WebElement htmlTableElement = findElement(locator); //instanciamos un objeto de tipo WebElement y le pasamos como parametro el elemento web
        List<WebElement> rowElements = htmlTableElement.findElements(By.xpath(".//tr")); //creamos una lista de tipo WebElement y le asignamos el valor del elemento web
        WebElement rowElement = rowElements.get(row-1); //creamos una variable de tipo WebElement y le asignamos el valor de la lista
        List<WebElement> cellElements = rowElement.findElements(By.xpath(".//td"));     //creamos una lista de tipo WebElement y le asignamos el valor de la lista
        WebElement colElement = cellElements.get(col-1); //creamos una variable de tipo WebElement y le asignamos el valor de la lista
        return colElement; //retornamos el valor de la celda
    }

    public String getValueFromTable(String locator, int row, int column){ //metodo para obtener el valor de una tabla
       // String cellValue = locator+"/table/tbody/tr["+row+"]/td["+column+"]"; //creamos una variable de tipo String y le asignamos el valor del elemento web
       return cellFinder(locator, row, column).getText(); //retornamos el valor de la tabla
    } 

    public void setValueOnTable(String locator, int row, int column, String valueToSend){ //metodo para establecer un valor en una tabla
        WebElement colElement = cellFinder(locator, row, column);
        try {
            colElement.sendKeys(valueToSend);
        }
        catch(Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '"+ valueToSend +"';", colElement);
        }
        
    }

    //Metodo para subir un archivo
    public void uploadFile(String locator, String pathFile){ //metodo para subir un archivo
        findElement(locator).sendKeys(pathFile); //instanciamos un objeto de tipo WebElement y le pasamos como parametro el elemento web
    }
    
    // Metodo que nos permite cambiar a otro frame
    public void switchToFrame(int  iFrameIndex){ //metodo para cambiar a otro frame
        driver.switchTo().frame(iFrameIndex); //instanciamos un objeto de tipo WebElement y le pasamos como parametro el elemento web
    }

    // Metodo que nos permite cambiar al parent frame
    public void switchToParentFrame(){ //metodo para cambiar al parent frame
        driver.switchTo().parentFrame(); //instanciamos un objeto de tipo WebElement y le pasamos como parametro el elemento web
    }
    // Metodos para manejar alertas
    public void acceptAlert(){ //metodo para aceptar una alerta
        driver.switchTo().alert().accept(); //instanciamos un objeto de tipo WebElement y le pasamos como parametro el elemento web
    }
    public void dismissAlert(){ //metodo para rechazar una alerta
        driver.switchTo().alert().dismiss(); //instanciamos un objeto de tipo WebElement y le pasamos como parametro el elemento web
    }

    public String textFromElements(String locator){ //metodo para obtener el texto de un elemento web
        return findElement(locator).getText(); //retornamos el texto del elemento web
    }

    public boolean isElementDisplayed(String locator){ //metodo para verificar si un elemento web esta desplegado
        return findElement(locator).isDisplayed(); //retornamos un valor booleano
    }
     public boolean isElementSelected(String locator){ //metodo para verificar si un elemento web esta seleccionado
        return findElement(locator).isSelected(); //retornamos un valor booleano    
         }

    public boolean isElementEnabled(String locator){ //metodo para verificar si un elemento web esta habilitado
        return findElement(locator).isEnabled(); //retornamos un valor booleano
    }
    public List<WebElement> bringMeAllElements(String locator){ //metodo para obtener todos los elementos web
        return driver.findElements(By.className(locator)); //retornamos una lista de elementos web
    } 
}


