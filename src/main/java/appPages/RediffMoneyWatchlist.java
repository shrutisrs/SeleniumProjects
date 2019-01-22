package appPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.Stocks;

public class RediffMoneyWatchlist {
	WebDriver driver;

	By row = By.xpath("//*[@id=\"stocks\"]/tbody/tr");
	By col = By.xpath("//*[@id=\"stocks\"]/thead/tr/th");
	
	public RediffMoneyWatchlist(WebDriver driver){
		this.driver = driver;
	}
	
	//Get the title of  page
    public String getTitle(){
    	return    driver.getTitle();
    }
	//load table of stocks
	public List<Stocks> getStocksDetails(){
		int rowCount = driver.findElements(row).size();
		String firstpart = "//*[@id=\"stocks\"]/tbody/tr[";
		String secondpart = "]/td[";
		String thirdpart = "]";
		
		List<Stocks> data = new ArrayList<Stocks>();
		for (int i = 1; i < rowCount; i++) {
			String final_xpath1 = firstpart+i+secondpart+2+thirdpart;
			String final_xpath2 = firstpart+i+secondpart+3+thirdpart;
			String final_xpath3 = firstpart+i+secondpart+7+thirdpart;
				String company = driver.findElement(By.xpath(final_xpath1)).getText();
				String price = driver.findElement(By.xpath(final_xpath2)).getText();
				String volume = driver.findElement(By.xpath(final_xpath3)).getText();
				
				Stocks s = new Stocks();
				s.setCompany(company);
				s.setPrice(price);
				s.setVolume(volume);
				data.add(s);

			}
		//System.out.println(data);
		for (Stocks stock : data) {
			
			System.out.println(stock);
		}
		return data;
	}

}
