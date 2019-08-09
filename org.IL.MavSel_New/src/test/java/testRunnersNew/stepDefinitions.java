package testRunnersNew;

import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.internal.runners.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
public class stepDefinitions {
	WebDriver driver;
/*	@Before("@Firefox")
	public void setupFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Before("@IE")
	public void setupChrome() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
*/	
	@Before
	public void setup() throws XmlPullParserException {
		String browser="";
		 try {
			  MavenXpp3Reader reader = new MavenXpp3Reader();
		        Model model = reader.read(new FileReader("pom.xml"));
		        browser = model.getProperties().toString();
		        System.out.println(browser);
		        browser = System.getProperty("browserName");
		        System.out.println(browser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if (browser.toUpperCase().contains("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.toUpperCase().contains("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.toUpperCase().contains("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Given("^User navigates to PHPTravels Login Page$")
	public void user_navigates_to_PHPTravels_Login_Page() {
		/*
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 */
		driver.navigate().to("https://www.phptravels.net/login");
		
	}
	@When("^User enters valid username and password$")
	public void user_enters_valid_username_and_password() {
		System.out.println("user_enters_valid_username_and_password");
		
	}
	@Then("^User navigates to Home Screen$")
	public void user_navigates_to_Home_Screen() {
		/* driver.quit(); */
	}
	
	@When("^User enters invalid ([^\"]*) and ([^\"]*)$")
	public void user_enters_invalid_username_and_password(String arg1, String arg2) {
		driver.findElement(By.name("username")).sendKeys(arg1);
		driver.findElement(By.name("password")).sendKeys(arg2);
		//driver.findElements(By.className("btn btn-action btn-lg btn-block loginbtn")).get(0).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//button[contains(.,'Checkout')]
		
	}
	
	@Then("^User sees error message$")
	public void user_sees_error_message() {
		Assert.assertEquals("Invalid Email or Password",driver.findElement(By.cssSelector(".alert")).getText());
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
/*	@After("@Firefox")
	public void tearDownFirefox() {
		driver.quit();
	}
	
	@After("@IE")
	public void tearIEDown() {
		driver.quit();
	}*/
}
