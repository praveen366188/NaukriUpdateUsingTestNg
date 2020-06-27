package stepDefenition;

import java.util.Arrays;

import javax.xml.xpath.XPath;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.time.Duration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDef {
	WebDriver driver;
	/*
	 * @FindBy(xpath = "//input[@id='usernameField']") public WebElement
	 * usernameField;
	 * 
	 * @FindBy(xpath = "//input[@id='passwordField']") public WebElement
	 * passwordField;
	 * 
	 * @FindBy(xpath = "//button[text()='Login']") public WebElement LoginButton;
	 * 
	 * @FindBy(xpath = "//div[contains(@class,'ser-name roboto-bold-text')]") public
	 * WebElement verifyUsernameInProfilePage;
	 */

	@Given("^Launch the browser with naukri url$")
	public void launch_the_browser_with_naukri_url() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Desktop\\pravi\\chromewebdriwer\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/nlogin/login?URL=http://www.naukri.com/mnjuser/homepage");
		driver.manage().window().maximize();
	}

	@Given("^Enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_the_and(String userName, String pwd) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='usernameField']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='passwordField']")).sendKeys(pwd);
	}

	@When("^Click the Login button$")
	public void click_the_Login_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Login']")).click();

	}

	@Then("^Verifying Naukri Profile page of \"([^\"]*)\"$")
	public void verifying_Naukri_Profile_page_of(String uname) throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals(uname,
				driver.findElement(By.xpath("//div[contains(@class,'ser-name roboto-bold-text')]")).getText().trim());
	}

	@When("^update the naukri prfile resume headline$")
	public void updateNaukriProfile() throws Throwable {
		driver.findElement(By.xpath("//div[contains(@class,'ser-name roboto-bold-text')]")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

		driver.findElement(By.xpath("//span[text()='Resume Headline']/following-sibling::span")).click();
		Thread.sleep(2000);

		Assert.assertEquals(true,
				driver.findElement(
						By.xpath("//span[contains(text(),'It is the first thing recruiters notice in your profile')]"))
						.isDisplayed());
		String s1 = driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).getText();
		System.out.println(s1);
		String[] splited = s1.split("\\s+");
		String lastString = splited[splited.length - 1];
		char[] lastStringToChar = lastString.toCharArray();
		char c = lastStringToChar[lastStringToChar.length - 1];
		String s;
		if (c == '.') {
			char[] ch = new char[lastString.length() - 1];
			for (int i = 0; i <= lastStringToChar.length - 2; i++) {
				ch[i] = lastStringToChar[i];
			}
			String b = new String(ch);
			splited[splited.length - 1] = b;
			 s=new String();
			for (int i = 0; i <= splited.length - 1; i++) {
				s=s+splited[i]+" ";
			}
			System.out.println(s);
		} else {
			splited[splited.length - 1] = splited[splited.length - 1]+".";
			 s=new String();
			for (int i = 0; i <= splited.length - 1; i++) {
				s=s+splited[i]+" ";
			}
			System.out.println(s);
		}
		driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).clear();
		
		driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).sendKeys(s);
		driver.findElement(By.xpath("//form[contains(@name,'resumeHeadlineForm')]//button[contains(text(),'Save')]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(true,
				driver.findElement(
						By.xpath("//p[contains(text(),'Resume Headline has been successfully saved.')]"))
						.isDisplayed());
	}

	@And("^Close the browser$")
	public void closeBrowser() throws Throwable {
		driver.close();

	}

}
