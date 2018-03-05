package au.icare.nsw.gov;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class NewTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\raranico\\Documents\\Selenium\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		System.out.println("This is a google site");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifySearchButton() {

		String search_text = "Google Search";
		WebElement search_button = driver.findElement(By.name("btnK"));

		String text = search_button.getAttribute("value");

		Assert.assertEquals(text, search_text, "Text not found!");

	}

}
