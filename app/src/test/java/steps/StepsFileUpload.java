package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UploadFilePage;

public class StepsFileUpload {
    
    UploadFilePage uploadFilePage = new UploadFilePage();

    @Given("^I navigate to the upload page$")
    public void navigateToUploadFilePage() {
        uploadFilePage.navigateToUploadFile();
    }

    @When("^I upload a file$")
    public void uploadFile() {
        uploadFilePage.uploadFile("C:/Users/David/Pictures/1163218.png");
    }

    @Then("^I can see the file uploaded$")
    public void validateFileUploaded() {
        uploadFilePage.clickUploadButton();
    }



}
