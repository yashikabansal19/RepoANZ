package stepDefinitions;


	import cucumber.api.PendingException;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.When;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.And;
	import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.CalculatorPage;


import resources.base;

import org.junit.runner.RunWith;

	public class calculatorsteps extends base
	{
		
		

	    @Given("^Initialize the browser with chrome$")
	    public void initialize_the_browser_with_chrome() throws Throwable {
	    	driver =initializeDriver();
	    	
	    }

	    @When("^User enters details $")
	    public void user_enters_details( ) throws Throwable {
	    	CalculatorPage cp = new CalculatorPage(driver);
	    	
	    	cp.getApplicationType("Single");

			cp.getNumberOfDependants("0");

			cp.getBuyingType("Home to live in");

	    }

	    @Then("^Verify that borrowing estimate is succesfully returned$")
	    public void verify_that_borrowing_estimate_is_succesfully_returned() throws Throwable {
	    	CalculatorPage cp = new CalculatorPage(driver);
	    	String ActualEstimateText = cp.getBorrowEstimateText();
			String ExpectedEstimateText = "We estimate you could borrow:";
	    	Assert.assertEquals(ActualEstimateText, ExpectedEstimateText);
	    }

	    @And("^Navigate to ANZ URL $")
	    public void navigate_to_anz_url() throws Throwable {
	    	driver.get(prop.getProperty("url"));
	    }

	    @And("^earnings$")
	    public void earnings(String annualIncome, String otherIncome, String secondIncome, String secondOther) throws Throwable {
	    	CalculatorPage cp = new CalculatorPage(driver);
	    	
	    	cp.getAnnualIncomeBeforeTax().sendKeys(annualIncome);

			cp.getOtherEarnings().sendKeys(otherIncome);

			cp.getSecondApplicantAnnual().sendKeys(secondIncome);

			cp.getSecondApplicantOther().sendKeys(secondOther);
	    }

	    @And("^expenses$")
	    public void expenses(String expense, String repayment, String otherloan, String othercommitment, String creditlimit) throws Throwable {
	    	CalculatorPage cp = new CalculatorPage(driver);
	    	cp.getMonthlyExpenses().sendKeys(expense);

			cp.getCurrentHomeLoan().sendKeys(repayment);

			cp.getOtherLoanRepayment().sendKeys(otherloan);

			cp.getOtherCommintments().sendKeys(othercommitment);

			cp.getTotalCreditCardLimit().sendKeys(creditlimit);
	    }

	}


