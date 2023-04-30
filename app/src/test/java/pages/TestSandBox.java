package pages;

public class TestSandBox extends BasePages{
    private String categoryDropdown = "//select[@id='dropdown']";

    public TestSandBox(){
        super(driver);
    }


    public void navigateToSandBox(){
        navigateTo("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectCategory(String category){
        selectDropDownByValue(categoryDropdown, category);
    }
}
