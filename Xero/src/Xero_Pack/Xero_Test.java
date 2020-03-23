package Xero_Pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
	  
	@Test(enabled = false)
	public void TC_ID_01_A_NavigateTOXero() throws Exception {
		logger = report.startTest("TC_1_oginTOXero");
		
		OpenUrl("https://www.xero.com/us/");
		logger.log(LogStatus.INFO, "TC_1_URL opened successfully");
		
		loginToXero();
		
		Thread.sleep(3000);
		//TitleXeroHome("Xero | Dashboard | self "); 
		TitleXeroHome("Xero | Dashboard | self");
		
				
	}
	@Test(enabled = false)
	public void TC_ID_01_B_IncorrectPasswordTOXero() {
		logger = report.startTest("TC_ID_01_B_IncorrectPasswordTOXero");
		
		OpenUrl("https://www.xero.com/us/");
		logger.log(LogStatus.INFO, "TC_1_URL opened successfully");
		
		WebElement loginBtn = driver.findElement(By.linkText("Login"));
		Click(loginBtn, "Login button");
		
		WebElement email = driver.findElement(By.id("email"));
		EnterText(email, "raisandhya2006@gmail.com", "EmailTextBox");
		
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "incorrectpwd", "passwordTextBox");
		
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		Click(submitBtn, "Login button");
		
		//driver.getPageSource().contains("Your email or password is incorrect");
		//Assert.assertTrue(driver.getPageSource().contains("Your email or password is incorrect"));
		//logger.log(LogStatus.INFO, "Your email or password is incorrect");
		
		boolean Error = driver.getPageSource().contains("Your email or password is incorrect");
	    if (Error == true){
	    	logger.log(LogStatus.PASS, "Your email or password is incorrect Text Present");
	     System.out.print("Your email or password is incorrect");
	    }
	    else
	    {
	    	logger.log(LogStatus.FAIL, "Your email or password is incorrect Text NOT Present");
	    }
	
	}
	
	@Test(enabled = false)
	public void TC_ID_01_C_IncorrectEmailTOXero() {
		logger = report.startTest("TC_ID_01_C_IncorrectEmailTOXero");
		
		OpenUrl("https://www.xero.com/us/");
		logger.log(LogStatus.INFO, "TC_1_URL opened successfully");
		
		WebElement loginBtn = driver.findElement(By.linkText("Login"));
		Click(loginBtn, "Login button");
		
		WebElement email = driver.findElement(By.id("email"));
		EnterText(email, "raisandhya2006@gmail", "EmailTextBox");
		
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "sandhya03", "passwordTextBox");
		
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		Click(submitBtn, "Login button");
		
		
		boolean Error = driver.getPageSource().contains("Your email or password is incorrect");
	    if (Error == true){
	    	logger.log(LogStatus.PASS, "Your email or password is incorrect Text Present");
	     System.out.print("Your email or password is incorrect");
	    }
	    else
	    {
	    	logger.log(LogStatus.FAIL, "Your email or password is incorrect Text NOT Present");
	    }

	}
	
	@Test
	public void TC_ID_01_D_ForgotPasswordTOXero() {
		logger = report.startTest("TC_ID_01_D_ForgotPasswordTOXero");
		
		OpenUrl("https://www.xero.com/us/");
		logger.log(LogStatus.INFO, "TC_1_URL opened successfully");
		
		WebElement loginBtn = driver.findElement(By.linkText("Login"));
		Click(loginBtn, "Login button");
		
		WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
		Click(forgotPasswordLink, "forgotPasswordLink");
		
		Assert.assertTrue(true, "Forgotten your password?");
		
		WebElement emailField = driver.findElement(By.id("UserName"));
		EnterText(emailField, "raisandhya2006@gmail.com", "email");
		
		//String emailValue = emailField.getAttribute("value");
		//System.out.println("The Value of VALUE attribute:" + emailValue);
		
		
		WebElement sendLink = driver.findElement(By.linkText("Send link"));
		Click(sendLink, "sendLink");
		
		Assert.assertTrue(driver.getPageSource().contains("Please check your email"));
		
		Assert.assertTrue(driver.getPageSource().contains("A link to reset your password has been sent to:"));
		logger.log(LogStatus.INFO, "A link to reset your password has been sent to:");
		Assert.assertTrue(driver.getPageSource().contains("raisandhya2006@gmail.com"));
		
		
		
		/*boolean Error = driver.getPageSource().contains("Your email or password is incorrect");
	    if (Error == true){
	    	logger.log(LogStatus.PASS, "Your email or password is incorrect Text Present");
	     System.out.print("Your email or password is incorrect");
	    }
	    else
	    {
	    	logger.log(LogStatus.FAIL, "Your email or password is incorrect Text NOT Present");
	    }*/

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
