package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;
import Test_Pages.LogInPage;

public class TC_LogIn extends Base{
	@Test
	public void LogIn() throws Exception {
		WebDriver driver= launchBrowser();
		LogInPage LP=new LogInPage(driver);
		LP.navigateUrl();
		LP.myaccount();
		LP.loginClick();
		
	}

}
