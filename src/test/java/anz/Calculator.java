package anz;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.CalculatorPage;
import resources.base;

public class Calculator extends base {
	public WebDriver driver;


	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String annualIncome, String otherIncome, String secondIncome, String secondOther,
			String expense, String repayment, String otherloan, String othercommitment, String creditlimit) throws InterruptedException {

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		CalculatorPage cp = new CalculatorPage(driver);
		cp.getApplicationType("Single");

		cp.getNumberOfDependants("0");

		cp.getBuyingType("Home to live in");

		cp.getAnnualIncomeBeforeTax().sendKeys(annualIncome);

		cp.getOtherEarnings().sendKeys(otherIncome);

		cp.getSecondApplicantAnnual().sendKeys(secondIncome);

		cp.getSecondApplicantOther().sendKeys(secondOther);

		cp.getMonthlyExpenses().sendKeys(expense);

		cp.getCurrentHomeLoan().sendKeys(repayment);

		cp.getOtherLoanRepayment().sendKeys(otherloan);

		cp.getOtherCommintments().sendKeys(othercommitment);

		cp.getTotalCreditCardLimit().sendKeys(creditlimit);

		cp.getHowMuchCouldBorrow().click();

		String ActualEstimateText = cp.getBorrowEstimateText();
		String ExpectedEstimateText = "We estimate you could borrow:";
		Assert.assertEquals(ActualEstimateText, ExpectedEstimateText);
	//	Assert.assertEquals("Passed", ActualEstimateText, ExpectedEstimateText ); 
		
		
		try {
			int EstimateBorrowAmount= cp.getBorrowEstimateAmount();
			
			System.out.println(EstimateBorrowAmount);
		} catch (Exception e) {
		}
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('button.start-over').click");
            

	}

     @AfterClass
      public void closeWindow()
     {
	
		driver.close();
	}
     
     
     

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][9];
		// 0th row - Your Earnings data
		data[0][0] = "80000";
		data[0][1] = "10000";
		data[0][2] = "500";
		data[0][3] = "20000";

		// 1st row - Your Expense data

		data[0][4] = "500";
		data[0][5] = "0";
		data[0][6] = "1000";
		data[0][7] = "0";
		data[0][8] = "10000";

		return data;

	}
	
@Test 
public void validateMessageForLivingExpense()
{
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	CalculatorPage cp = new CalculatorPage(driver);

	driver.get(prop.getProperty("url"));
	cp.getMonthlyExpenses().sendKeys("1");
	
	cp.getHowMuchCouldBorrow().click();
	
	String ExpectedBorrowTextError = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
	
	String ActualBorrowTextError = cp.getBorrowErrorText();
	
	
	Assert.assertEquals( ExpectedBorrowTextError, ActualBorrowTextError);
	

	
}

}















