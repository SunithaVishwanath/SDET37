package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author SanjayBabu
 *
 */
public class LoginPage {
	//intialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaretion
	
	//@FindBy(name = "user_name")
	//@FindBys({@FindBy(name = "user_name"),@FindBy(xpath = "//input[@type='text']")})
	@FindAll({@FindBy(name = "user_name"),@FindBy(xpath = "//input[@type='tex']")})
	private WebElement usernameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement submitBtn;

	//utilization   (create business libraries)
	public WebElement getusernameEdt()
	{
		return usernameEdt;
	}

	public WebElement getpasswordEdt()
	{
		return passwordEdt;
	}

	public WebElement getsubmitBtn()
	{
		return submitBtn;
	}


	public void loginToApp(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}

}
