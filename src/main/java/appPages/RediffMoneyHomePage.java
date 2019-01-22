package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffMoneyHomePage {

	WebDriver driver;
	By mywatchlist = By.linkText("My Watchlist");

	public RediffMoneyHomePage(WebDriver driver){

        this.driver = driver;

    }
	
	//Click on WatchList link

    public void clickWatchlistLink(){

            driver.findElement(mywatchlist).click();

    }

	//Get the title of Home Page

    public String getLoginTitle(){

     return    driver.getTitle();

    }
}
