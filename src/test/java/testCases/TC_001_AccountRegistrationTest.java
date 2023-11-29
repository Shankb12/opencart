package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Regression, Master"})
	public void test_account_Registration() {
		
		logger.info("********** TC_001_AccountRegistrationTest *********");
		logger.debug("capturing debug logs.......");
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		hp.clickRegister();
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		logger.info("Providing Customer details....");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		String pwd=randomAlphanumeric();
		regpage.setPassword(pwd);
		regpage.setConfirmPassword(pwd);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked on continue button....");
		String actualmsg=regpage.getConfirmationmsg();
		if(actualmsg.equals("Your Account Has Been Created!")) {
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed");
			Assert.assertTrue(false);
		}
			logger.info("********** Finished  TC_001_AccountRegistrationTest *********");
	
	}

}
