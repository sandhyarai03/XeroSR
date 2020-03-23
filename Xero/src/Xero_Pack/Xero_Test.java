package Xero_Pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Xero_Test extends ReusableClass_Xero_Test{
	
	@BeforeTest
	@Parameters("browser")
	public void Initialize(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if ((browserName.equalsIgnoreCase("Firefox")))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No Browser is setup to run the testcase");
		}
		CreateReport();
	}
	  
	@Test(priority=1)
	public void TC_ID_01_A_NavigateTOXero() throws Exception {
		logger = report.startTest("TC_1_oginTOXero");
		
		OpenUrl("https://www.xero.com/us/");
		logger.log(LogStatus.INFO, "TC_1_URL opened successfully");
		
		loginToXero();
		
		Thread.sleep(3000);
		//TitleXeroHome("Xero | Dashboard | self "); 
		TitleXeroHome("Xero | Dashboard | self");
		
				
	}
	@Test(enabled = false, dependsOnMethods={"TC_ID_01_A_NavigateTOXero"})
	public void TC_ID_02_A_SignupTOXero() throws InterruptedException {
		logger = report.startTest("TC_1_oginTOXero");
		
		OpenUrl("https://www.xero.com/us/");
		logger.log(LogStatus.INFO, "TC_1_URL opened successfully");
		
		WebElement freeTrial =  driver.findElement(By.linkText("Free trial"));
		Click(freeTrial, "FreeTrial");
		
		logger.log(LogStatus.INFO, "Free Trial Button is clicked");
		Thread.sleep(2000);
		
		driver.getTitle().contains("Signup for Xero - Free Trial | Xero US");
		
		TitleFreeTrial("Signup for Xero - Free Trial | Xero US");
		
		FreeTrialForm();
			
		
		
	}
	@AfterTest
	public void cleanup(){
		CloseBrowser();
		CloseReport() ;
	}
	
}
