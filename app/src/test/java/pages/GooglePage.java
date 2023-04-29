package pages;

public class GooglePage extends BasePages{ //heredamos de la clase BasePages

    private String searchButton = "//input[@value='Buscar con Google']";//variable de tipo String que contiene el xpath del elemento web
    private String searchTextField ="//textarea[@id='APjFqb']"; //variable de tipo String que contiene el xpath del elemento web para buscar
    public GooglePage(){ //constructor
        super(driver);
    }

    public void navigateToGoogle(){ //metodo para navegar a google
        navigateTo("https://www.google.com/"); //llamamos al metodo navigateTo de la clase BasePages
    }

    public void clickGoogleSearch(){ //metodo para hacer click en el boton de busqueda
        clickElement(searchButton); //llamamos al metodo clickElement de la clase BasePages
    }

    public void writeSearchCriteria(String searchCriteria){ //metodo para escribir el criterio de busqueda
        writeText(searchTextField, searchCriteria); //llamamos al metodo writeText de la clase BasePages
    }


    
}
