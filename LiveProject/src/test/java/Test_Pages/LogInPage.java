package Test_Pages;
import Resources.Base;

import java.security.PublicKey;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;

public class LogInPage extends Base {
	public static WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//a[@title='My Account']") WebElement myaccount;
	@FindBy(linkText = "Loginbutton") WebElement login;

	public void navigateUrl() throws Exception {
		try {
			driver.navigate().to(prop.getProperty("URL"));
			Base.parentTest.pass("Successfully logged in into : "+prop.getProperty("URL"),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		} catch (Exception e) {
			Base.parentTest.fail("Unable to log-in into : "+prop.getProperty("URL"),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			Base.parentTest.info(e);
			throw e;
		}
		
	}
	public void myaccount() throws Exception {
		try {
			myaccount.click();
			Thread.sleep(4000);
			Base.parentTest.pass("myaccount button is clicked : "+myaccount,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			
		} catch (Exception e) {
			Base.parentTest.fail("myaccount in button is not clicked: "+myaccount,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			Base.parentTest.info(e);
			throw e;
		}
	
	}

	public void loginClick() throws Exception  {
		try {
			login.click();
			Thread.sleep(4000);
			Base.parentTest.pass("Log in button is not clicked: "+login,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			
		} catch (Exception e) {
			Base.parentTest.fail("log in button is not clicked: "+login,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			Base.parentTest.info(e);
			throw e;
		}
	
	}
	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
	}
}

