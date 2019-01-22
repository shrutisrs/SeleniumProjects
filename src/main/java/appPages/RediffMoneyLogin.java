package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffMoneyLogin {

	WebDriver driver;
	By email = By.name("email-id");
	By continuebutton = By.id("emailsubmit");
	By password = By.id("userpass");
	By loginbutton = By.id("loginsubmit");

	public RediffMoneyLogin(WebDriver driver) {
		this.driver = driver;
	}
	//Get the title of Login page
    public String getLoginTitle(){
    	return    driver.getTitle();
    }
    //Set user name
    public void setEmail(String username){
    	driver.findElement(email).sendKeys(username);
    }
    //click on the continue button
    public void clickContinue(){
    	driver.findElement(continuebutton).click();
    }
    //Set password
    public void setPassword(String pass){
    	driver.findElement(password).sendKeys(pass);
    }
    //click on login button
    public void login(){
    	driver.findElement(loginbutton).click();
    }
    public void loginRediffMoney(String username,String pass){
    	this.setEmail(username);
    	this.clickContinue();
    	this.setPassword(pass);
    	this.login();
    }
    
}
