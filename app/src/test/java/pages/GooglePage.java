package pages;

public class GooglePage extends BasePages{ //heredamos de la clase BasePages

    private String searchButton = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]";//variable de tipo String que contiene el xpath del elemento web

    public GooglePage(){ //constructor
        super(driver);
    }

    public void navigateToGoogle(){ //metodo para navegar a google
        navigateTo("https://www.google.com/"); //llamamos al metodo navigateTo de la clase BasePages
    }

    public void clickGoogleSearch(){ //metodo para hacer click en el boton de busqueda
        clickElement(searchButton); //llamamos al metodo clickElement de la clase BasePages
    }


    
}
