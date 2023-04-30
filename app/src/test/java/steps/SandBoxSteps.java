package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.TestSandBox;

public class SandBoxSteps {

    TestSandBox testSandBox = new TestSandBox();

    @Given("^I navigate to the sandbox page$")
    public void navigateToSandBox() {
        testSandBox.navigateToSandBox();
    }

    @And ("Select a value from the dropdown")
    public void selectCategory(){
        testSandBox.selectCategory("2");
    }
    
}
