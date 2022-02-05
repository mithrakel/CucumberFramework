package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonLoginPage;
import pages.AmazonSearchPage;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonLoginSteps {
	
	AmazonLoginPage amazonlp = new AmazonLoginPage();

	@Given("I am on amazon home page")
	public void i_am_on_amazon_home_page() {
	   System.out.println("On the home Page");
	   Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
	}
	@Given("The sign in button displays")
	public void the_sign_in_button_displays() {
	   System.out.println("Button displayed");
	   	Assert.assertTrue(amazonlp.signInButton.isDisplayed());
	   

	}
	@When("I click on the sign in button")
	public void i_click_on_the_sign_in_button() {
	  System.out.println("Click the button");
	  	amazonlp.signInButton.click();
	}
	@Then("I should be directed to log in page")
	public void i_should_be_directed_to_log_in_page() {
	    System.out.println("On the log in page");
	    Assert.assertTrue(amazonlp.emailBox.isDisplayed());
	}
	
	
	// invalid user tests #Start
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
		amazonlp.signInButton.click();
		Assert.assertTrue(amazonlp.emailBox.isDisplayed());
	}
	@When("I enter invalid password {string}")
	public void i_enter_invalid_password(String email) {
		amazonlp.emailBox.sendKeys(email);

	}
	@When("I click the continue button")
	public void i_click_the_continue_button() {
		amazonlp.continueBtn.click();


	}
	@Then("I should get Error message says {string}")
	public void i_should_get_error_message_says(String expectedErrorMessage) {
		Assert.assertTrue(amazonlp.errorMessage.isDisplayed());
		String actualText = amazonlp.errorMessage.getText().trim();
		Assert.assertEquals(actualText, expectedErrorMessage);
	 
	}
	@Then("I should still in the login page")
	public void i_should_still_in_the_login_page() {
		Assert.assertTrue(amazonlp.emailBox.isDisplayed());
	   
	}
	
	//invalid user test #End

}
