package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import pages.GridTestPage;
 
public class GridSteps {

    GridTestPage gridPage = new GridTestPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage() {
       gridPage.navigateToGrid();
    }
    @Then("^I can return the value I wanted$")
    public void returnValue() {
        gridPage.setValueOnGrid(3, 2, "David"); 

       String value = gridPage.getValueFromGrid(3,2);
        System.out.println(value);
    }

}
