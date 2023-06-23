package steps;


import java.util.List;

import io.cucumber.java.en.*;
import pages.ListPages;

public class ListSteps {

    ListPages listPages = new ListPages();

    @Given("^I navigate to the list page$")
    public void navigateToListPage() {
        listPages.navigateToListPage();
    }
    @When("^I shearch the list$")
    public void searchTheList() throws InterruptedException {
        listPages.enterSearchCriteria("A");
    }

    @Then("^I can find the text in the list$")
    public void theTableisThere() {
        List<String> list = listPages.getAllSearchResults();
        boolean textIsThere = list.contains("Acatla");
        if(textIsThere){
            System.out.println("The text is there :PASSED");
        }else{
            System.out.println("The text is not there :FAILED");
        }
    }
    

    
}
