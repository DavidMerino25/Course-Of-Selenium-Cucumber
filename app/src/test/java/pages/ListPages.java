package pages;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
public class ListPages extends BasePages{
    
    private String searchField = "//body/div[1]/div[1]/div[1]/span[1]/input[2]"; //xpath del campo de busqueda
    private String searchResults= "tt-suggestion"; //xpath de los resultados de la busqueda
    public ListPages() {
        super(driver);
    }
    
    public void navigateToListPage(){ //metodo para navegar a la pagina del  ejempplo del typehad 
        navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }
    public void enterSearchCriteria(String search) throws InterruptedException{ //metodo para escribir en el campo de busqueda
            Thread.sleep(600);
            writeText(searchField, search);


    }
    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();
        for (WebElement element : list) {
            stringsFromList.add(element.getText());
        }
        return stringsFromList;

    }

}
