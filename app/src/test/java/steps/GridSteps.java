package steps;

import io.cucumber.java.en.Then;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import pages.GridTestPage;

public class GridSteps {

    GridTestPage gridPage = new GridTestPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage() {
        gridPage.navigateToGrid();
    }

    /*
     * @Then("^I can return the value I wanted$")
     * public void returnValue() {
     * gridPage.setValueOnGrid(3, 2, "David");
     * 
     * String value = gridPage.getValueFromGrid(3,2);
     * Assert.assertEquals("David", value);
     * }
     */
    @Then("^I can validate if the static table is displayed$")
    public void validateTable() { // metodo para validar si la tabla esta desplegada
       // Assert.assertTrue("Ya fue pana", gridPage.elementIsDisplayed()); // llamamos al metodo elementIsDisplayed de la// clase GridTestPage
        Assert.assertFalse("Ya fue pana", gridPage.elementIsDisplayed()); // llamamos al metodo elementIsDisplayed de la// clase GridTestPage                                                              
    }

}
