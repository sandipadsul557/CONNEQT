package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.webutil;

public class loginPage {
	public webutil loginutil;
	public loginPage (webutil util) {
		
		loginutil = util;
		PageFactory.initElements(loginutil.driver,this);
	}
	
	@FindBy(id ="txtUsername") WebElement user ;
	@FindBy(id="txtPassword")WebElement pass;
	@FindBy(id= "btnLogin") WebElement loginButton;
	
	public void username() {
		user.sendKeys("Admin");
	}
	public void passward() {
		pass.sendKeys("admin123");
	}
	public void button() {
		loginButton.click();
	}
	
}
