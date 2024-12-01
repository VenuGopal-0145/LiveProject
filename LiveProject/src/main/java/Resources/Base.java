package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class Base {
	public WebDriver driver;
	String browser;
	public static  Properties prop;
	
	ExtentSparkReporter htmlreport;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	
	@BeforeTest
	public void report() {
		htmlreport= new ExtentSparkReporter("Reports/MyResult.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreport);
	}
	
	
	@BeforeMethod
	public void method(Method method) {
		parentTest=extent.createTest(method.getName());
	}
	
	
	@BeforeClass
	public WebDriver launchBrowser() throws IOException
	{ 
		prop=new Properties();
		FileInputStream FS=new FileInputStream("C:\\Users\\721326\\Mission_Selenium\\LiveProject\\src\\main\\java\\Resources\\Data.properties");
		prop.load(FS);
		browser=prop.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("FireFox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
		}
		else if (browser.equalsIgnoreCase("Safari")) {
			driver=new SafariDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		extent.flush();
	}

}
