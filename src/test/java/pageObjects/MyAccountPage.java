package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
 public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading;
 
 public boolean isMyAccountPageExists() {
	 try {
		return(msgHeading.isDisplayed());
	 }
	 catch(Exception e) {
		 return false;
	 }

	
 }
 
 @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
 WebElement lnkLogout;
 
 public void clickLogout() {
	 lnkLogout.click();
 }
}
