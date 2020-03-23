package Xero_Pack;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableClass_Xero_Test {
	
	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;
	
	static String Xero_EmailID = "raisandhya2006@gmail.com";
	static String Xero_Pwd = "sandhyarai";
	
	public static void CreateReport() {
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "/Users/sandhya/Desktop/TC_Report/" + fileName;
		//String path = "/Users/sandhya/Desktop/TC_Report/testfile.html";
		report = new ExtentReports(path);
		
	}
	public static void CloseBrowser() {
		driver.quit();
	}
	
	public static void CloseReport() {
		report.flush();
	}
	
	public static void OpenUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, "First NAme TextBox not found");
		}else {
			logger.log(LogStatus.INFO, "First NAme Entered");
			element.sendKeys(text);
		}		
	}
	
	public static void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, "Element is not found");
		}else {
			logger.log(LogStatus.INFO, "Element is found");
			element.click();
		}
		
	}
	public static void loginToXero() {
		
		WebElement loginBtn = driver.findElement(By.linkText("Login"));
		Click(loginBtn, "Login button");
		
		WebElement email = driver.findElement(By.id("email"));
		EnterText(email, "raisandhya2006@gmail.com", "EmailTextBox");
		
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "sandhya03", "passwordTextBox");
		
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		Click(submitBtn, "Login button");
	}
	
	public static void TitleXeroHome(String expectedTitleXeroHome) throws Exception {
		
		String actualTitle = driver.getTitle();
		
		if (actualTitle.equalsIgnoreCase(expectedTitleXeroHome)) {
			System.out.println(actualTitle = driver.getTitle());
			
			logger.log(LogStatus.PASS, actualTitle + " User's Home Page is displaying ");
			//logger.log(LogStatus.PASS, actualTitle);
		}
		else {
			logger.log(LogStatus.FAIL, actualTitle + " Actual Title NOT found");
			//logger.log(LogStatus.FAIL, actualTitle);
	}
		Thread.sleep(2000);
	}

	
	public static void TitleFreeTrial(String expectedFreeTrialTitle) throws InterruptedException {
		//String expectedFreeTrialTitle = "Signup for Xero - Free Trial | Xero US";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedFreeTrialTitle)) {
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, actualTitle + " Actual Title FOUND ");
		}
		else {
			logger.log(LogStatus.FAIL, actualTitle + " Actual Title NOT found");
	}
		System.out.println(actualTitle);
}
	public static void FreeTrialForm() {
		
		driver.findElement(By.name("FirstName")).sendKeys("FirstSandy");
		logger.log(LogStatus.INFO, "First Name Entered");
		
		driver.findElement(By.name("LastName")).sendKeys("LastSandy");
		logger.log(LogStatus.INFO, "Last Name Entered");
		
		driver.findElement(By.name("EmailAddress")).sendKeys("raisandhya2006@gmail.com");
		logger.log(LogStatus.INFO, " email Entered ");
		
		driver.findElement(By.name("PhoneNumber")).sendKeys("5104024121");
		logger.log(LogStatus.INFO, " phone number Entered ");
		
		Select countryDropdwn = new Select(driver.findElement(By.xpath("//select[@name='LocationCode']")));
		
		
		countryDropdwn.selectByVisibleText("India");
		countryDropdwn.selectByVisibleText("United States");
		
		logger.log(LogStatus.INFO, " Country Selected");
		
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		
		
		SwitchFrame(1);
		
		System.out.println("Inside the CAPTCHA");
		
		WebElement captcha = driver.findElement(By.xpath("//div[@class='g-recaptcha form-group']//div//div//iframe[1]"));
		Click(captcha, "CAPTCHA checkBox");
		
		 driver.findElement(By.xpath("//label[contains(@class,'form-label text')]//input")).click();

		
	}
	public static void SwitchFrame(String id) {
		driver.switchTo().frame(id);
		System.out.println("Pass: we can switch to the " + id + " frame");
	}
	
	public static void SwitchFrame_AbsuPath(String absuPath) {
		driver.switchTo().frame(absuPath);
		System.out.println("Pass: we can switch to the " + absuPath + " frame");
	}
	
	public static void SwitchFrame(WebElement element) {
		driver.switchTo().frame(element);
		System.out.println("Pass: we can switch to the frame");
	}
	public static void SwitchFrame(int index) {
		driver.switchTo().frame(index);
		System.out.println("Pass: we can switch to the frame");
	}

	public static void SwitchFrame() {
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the frame");
	}
}
