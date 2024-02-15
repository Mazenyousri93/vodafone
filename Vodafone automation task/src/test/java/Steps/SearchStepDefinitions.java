package Steps;

import Pages.baseTests;
import Pages.homePage;
import Pages.smartPhonesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;


public class SearchStepDefinitions extends baseTests {
    //instantiating objects from homePage and smartPhonePage
    homePage hP = new homePage();
    smartPhonesPage sP = new smartPhonesPage();

    public SearchStepDefinitions() throws IOException {
    }


    @Given("User is in Vodafone ecommerce website homepage")
    public void navigateToLoginPage() throws IOException {
        baseTests.setUp();
    }
    @And("I dismiss the cookies pop up")
    public void dismissCookiesPopUp(){
        hP.clickCookiesDismissButton(driver);
    }
    @When("I press the smart phone button in the upper menu")
    public void selectSmartPhones(){
        hP.clickSmartPhoneButton(driver);
    }
    @When("I select the apple section of the store")
    public void selectAppleSection(){
        sP.selectApple(driver);
    }
    @And("I enter the search value in the search bar")
    public void enterSearchItem(){
        sP.enterSearchWord(driver,prop.getProperty("searchItem"));
    }
    @Then("I verify that the results are relevant")
    public void assertResults(){
        sP.assertSearchResults(driver,prop.getProperty("searchItem"));
    }


//After method to close the driver after test execution
    @After
    public void after(){
        baseTests.tearDown(driver);
    }
}
