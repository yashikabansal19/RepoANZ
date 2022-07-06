package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {

	public WebDriver driver;

	By applicationtypejoint = By.cssSelector("label[for='application_type_joint']");
	By yourAnnualIncomebeforetax = By.xpath("//div[@class=\"input__wrapper\"]/input[@aria-describedby=\"q2q1i1 q2q1i2\"]");
	By yourAnnualOtherIncome = By.xpath("//div[@class=\"input__wrapper\"]/input[@aria-describedby=\"q2q2i1 q2q2i2\"]");
	By secondApplicantIncome = By.xpath("//div[@class=\"input__wrapper\"]/input[@aria-labelledby=\"q2q3\"]");
	By secondApplicantOtherIncome = By.xpath("//div[@class=\"input__wrapper\"]/input[@aria-labelledby=\"q2q4\"]");
	
	By monthlyLivingExpenses = By.id("expenses");
	
	By currentHomeLoan = By.id("homeloans");
	
	By otherLoanRepayment = By.id("otherloans");
	
	By otherCommintments = By.xpath("//div[@class=\"input__wrapper\"]/input[@aria-labelledby=\"q3q4\"]");
	By totalCreditCardLimit = By.xpath("//div[@class=\"input__wrapper\"]/input[@aria-labelledby=\"q3q5\"]");
	
	By borrowCalculator = By.xpath("//button[@id='btnBorrowCalculater']");
	
	By borrowEstimateText = By.cssSelector("h3[class='homeloan__borrow__text']");
	By borrowEstimateAmount = By.cssSelector("#borrowResultTextAmount");
	
	By startOver = By.xpath("//button[contains(text(),'Start over')]");
	
	By borrowText = By.cssSelector(".borrow__error__text");

	public CalculatorPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public List<WebElement> getApplicationType(String apptype) {
		List<WebElement> applicationtype = driver.findElements(By.cssSelector("label[for*='application_type']"));
		for (int i = 0; i < applicationtype.size(); i++) {
			if (applicationtype.get(i).getText().equalsIgnoreCase("Single")) {
				applicationtype.get(i).click();
			}

			else if (applicationtype.get(i).getText().equalsIgnoreCase("Joint")) {
				applicationtype.get(i).click();
			}
		}

		return applicationtype;

	}

	public String getNumberOfDependants(String nod) {
		WebElement dependants = driver.findElement(By.xpath("//select[@title='Number of dependants']"));

		Select depdropdown = new Select(dependants);
		depdropdown.selectByVisibleText(nod);

		return nod;
	}

	public List<WebElement> getBuyingType(String buyingValue) {
		List<WebElement> borrowtype = driver.findElements(By.cssSelector("label[for*='borrow_type']"));
		for (int i = 0; i < borrowtype.size(); i++) {
			if (borrowtype.get(i).getText().equalsIgnoreCase("Home to live in")) {
				borrowtype.get(i).click();
			}

			else if (borrowtype.get(i).getText().equalsIgnoreCase("Residential investment")) {
				borrowtype.get(i).click();
			}
		}

		return borrowtype;

	}

	public WebElement getAnnualIncomeBeforeTax() {

		WebElement annualIncomeBeforeTax = driver.findElement(yourAnnualIncomebeforetax);

		return annualIncomeBeforeTax;
	}

	public WebElement getOtherEarnings() {
		WebElement otherAnnualIncome = driver.findElement(yourAnnualOtherIncome);

		return otherAnnualIncome;
	}

	public WebElement getSecondApplicantAnnual() {
		WebElement secondAnnualIncome = driver.findElement(secondApplicantIncome);

		return secondAnnualIncome;
	}

	public WebElement getSecondApplicantOther() {
		WebElement secondOtherIncome = driver.findElement(secondApplicantOtherIncome);

		return secondOtherIncome;
	}
	
	public WebElement getMonthlyExpenses() {
		WebElement monthlyExpenses = driver.findElement(monthlyLivingExpenses);

		return monthlyExpenses;
	} 
	
	public WebElement getCurrentHomeLoan() {
		WebElement HomeLoan = driver.findElement(currentHomeLoan);

		return HomeLoan;
	} 
	
	public WebElement getOtherLoanRepayment() {
		WebElement OtherLoan = driver.findElement(otherLoanRepayment);

		return OtherLoan;
	} 
	
	public WebElement getOtherCommintments() {
		WebElement Commitments = driver.findElement(otherCommintments);

		return Commitments;
	} 
	
	public WebElement getTotalCreditCardLimit() {
		WebElement CreditLimit = driver.findElement(totalCreditCardLimit);

		return CreditLimit;
	} 
	
	public WebElement getHowMuchCouldBorrow()
	{
		WebElement CouldBorrow = driver.findElement(borrowCalculator);
		return CouldBorrow;
		
	}
	
	public String getBorrowEstimateText()
	{
		String EstimateBorrowText = driver.findElement(borrowEstimateText).getText();
		return EstimateBorrowText;
		
	} 
	
	public int getBorrowEstimateAmount()
	{
		String EstimateBorrowAmount= driver.findElement(borrowEstimateAmount).getText();
		
		int amount = Integer.parseInt(EstimateBorrowAmount);
		return amount;
		
	} 
	
	public WebElement getStartOverClicked()
	{
		WebElement clickStartOver = driver.findElement(startOver);
		
		return clickStartOver;
		
		
	}
	
	public String getBorrowErrorText()
	{
        String borrowTextError = driver.findElement(borrowText).getText();
		
		return borrowTextError;
	}
	
	
	
	
	
	

}
