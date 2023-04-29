package steps;

import io.cucumber.java.en.*;
import pages.GooglePage;

public class GoogleSteps {

   GooglePage googlePage = new GooglePage();
    
   @Given("^I am on the Google search page$")
   public void navigateToGoogle() {
      googlePage.navigateToGoogle(); //llamamos al metodo navigateToGoogle de la clase GooglePage
      googlePage.clickGoogleSearch(); //llamamos al metodo clickGoogleSearch de la clase GooglePage
   }

   @When("^I enter a search criteria")
   public void enterSearchCriteria() {
      
   }
   @And("^Click on the search button$")
   public void clickSearchButton() {
      
   }

   @Then("^The result matches the search criteria$")
   public void validateResults() {
      
   }

}
