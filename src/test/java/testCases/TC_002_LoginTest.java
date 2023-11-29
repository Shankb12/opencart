package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
//this is login test
public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity, Master"})
	public void test_login() {
		//rb= ResourceBundle.getBundle("config");
		
		logger.info("**************Starting TC_002_LoginTest**************");
		try{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
		logger.info("test passed");
		}
		catch(Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*****finished Login testcase*********");
		
		
	}
}
