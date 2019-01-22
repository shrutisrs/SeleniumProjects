package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appPages.RediffMoneyHomePage;

public class TestRediffMoneyHomePage {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void checkHomepageTitle() {
		RediffMoneyHomePage redmyhmpg = new RediffMoneyHomePage(driver);
		Assert.assertTrue(redmyhmpg.getLoginTitle().contains("BSE:"));
	}

	@AfterClass
	public void endSession() {
		driver.close();
	}
}