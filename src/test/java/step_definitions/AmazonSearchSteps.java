package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonSearchPage;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonSearchSteps {
	
	// amazon search # starts
	
	AmazonSearchPage searchPage = new AmazonSearchPage();
	
	@Given("I am on Amazon home page")
	public void i_am_on_amazon_home_page() {
		 System.out.println("On the home Page");
		   Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
	}
	
	@When("I search item {string}")
	public void i_search_item(String item) {
		searchPage.searchBox.sendKeys(item);
	    
	}
	@When("I click search button")
	public void i_click_search_button() {
		searchPage.searchButton.click();
	   
	}
	@Then("searched item {string} should be displayed in the search bar")
	public void searched_item_should_be_displayed_in_the_search_bar(String item) {
		
		String wholeText = searchPage.searchItemText.getText();
		String trimmedText = wholeText.substring(1, wholeText.length()-1);
		Assert.assertEquals(trimmedText, item);
	    
	}
	
	// amazon search # ends

}
