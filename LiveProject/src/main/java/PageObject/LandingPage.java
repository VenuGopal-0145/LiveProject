package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {
	public WebDriver driver;
	public WebElement landingElement;
	public void LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "") WebElement myaccountElement;
	public WebElement landing()
	{
		return landingElement;
		
	}
	

}
