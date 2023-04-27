package pages;

public class GooglePage extends BasePages{

    public GooglePage(){
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com/");
    }
    
}
