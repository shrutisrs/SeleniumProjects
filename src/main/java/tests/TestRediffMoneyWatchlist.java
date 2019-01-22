package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appPages.RediffMoneyHomePage;
import appPages.RediffMoneyLogin;
import appPages.RediffMoneyWatchlist;

public class TestRediffMoneyWatchlist {
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

	@Test(priority=1)
	public void watchlistpage() {
		RediffMoneyHomePage redmyhmpg = new RediffMoneyHomePage(driver);
		redmyhmpg.clickWatchlistLink();
		RediffMoneyLogin redmylogin = new RediffMoneyLogin(driver);
		redmylogin.loginRediffMoney("s.agrawal@gmail.com", "*****");
		RediffMoneyWatchlist redwtlist = new RediffMoneyWatchlist(driver);
		String titlewtls = redwtlist.getTitle();
		Assert.assertEquals(titlewtls, "Indian stock markets: Login to Portfolio", "we moved to watchlist");
	}

	@Test(priority=2)
	public void rowcount() {
		RediffMoneyHomePage redmyhmpg = new RediffMoneyHomePage(driver);
		redmyhmpg.clickWatchlistLink();
		RediffMoneyLogin redmylogin = new RediffMoneyLogin(driver);
		redmylogin.loginRediffMoney("s.agrawal@gmail.com", "*****");
		RediffMoneyWatchlist redwtlist = new RediffMoneyWatchlist(driver);
		int totaltrows = redwtlist.getStocksDetails().size();
		Assert.assertEquals(totaltrows, 41);
	}

	@AfterClass
	public void endSession() {
		driver.close();
	}
}
