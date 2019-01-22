package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appPages.RediffMoneyHomePage;
import appPages.RediffMoneyLogin;


public class TestRediffMoneyLogin {
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

	@Test(priority = 1)
	public void homepage() {
		RediffMoneyHomePage redmyhmpg = new RediffMoneyHomePage(driver);
		System.out.println(redmyhmpg.getLoginTitle());
		Assert.assertTrue(redmyhmpg.getLoginTitle().contains("BSE:"));
		redmyhmpg.clickWatchlistLink();
		RediffMoneyLogin redmylogin = new RediffMoneyLogin(driver);
		String titleloginpg = redmylogin.getLoginTitle();
		System.out.println(redmylogin.getLoginTitle());
		assertEquals(titleloginpg, "Indian stock markets: Login to Portfolio");

		redmylogin.loginRediffMoney("s.agrawal@gmail.com", "*****");
	}

	@Test(priority = 2)
	public void errorLogin() {
		RediffMoneyHomePage redmyhmpg = new RediffMoneyHomePage(driver);
		redmyhmpg.clickWatchlistLink();
		RediffMoneyLogin redmylogin = new RediffMoneyLogin(driver);
		redmylogin.loginRediffMoney("s.agrawal@gmail.com", "1234");
		String acmsg = driver.findElement(By.xpath("//*[@id=\"message_shows\"]/div")).getText();
		Assert.assertEquals(acmsg, "Username and password does not match. Try again.");
	}

	@AfterClass
	public void endSession() {
		driver.quit();
	}
}