package SwiggyPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwiggyBaseClass.BaseClass;

public class LoginPage extends BaseClass{
	
	//@FindBy(xpath="//span[contains(text(),'Sign In')]")
	//WebElement Signin;
	//@FindBy(xpath="//input[@id=\"mobile\"]")
	//WebElement MobileNo;
	
	@FindBy(xpath="//input[@id=\"location\"]")
	WebElement locationTextbox;
	
	@FindBy(xpath="//*[@class='_2W-T9'][1]")
	WebElement selectlocation;
	
    @FindBy(xpath="//span[contains(text(),'Search')]")
	WebElement search;
	
	@FindBy(xpath="//input[@placeholder='Search for restaurants and food']")
	WebElement searchTextbox;
	
	@FindBy(xpath="//*[@class='RNzoC'][1]")
	WebElement selectfood;
	
	public LoginPage() {
		PageFactory.initElements(driver,this );

} 
	
	
	public WebElement getButtonlocation() {
		return locationTextbox;
		
	}

	
	public void location(String locationText) {
		
		//clickElement(location);
		this.locationTextbox.sendKeys(locationText);
		selectlocation.click();
		
		
		
      }

	public WebElement clickOnsearch() {
		return search;
		
		
	}
	
     public void searchtext(String foodname) {
		
		clickElement(search);
		this.searchTextbox.sendKeys(foodname);
		
		selectfood.click();
		
		
	}
	
	
	
}		
	
	
	

