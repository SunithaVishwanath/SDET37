package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;
/**
 * 
 * @author SanjayBabu
 *
 */
public class HomePage extends WebDriverUtility{

	//initilaization 

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaretion

	@FindBy(xpath = "//a[.='Organizations']") private WebElement organisationsLink;

	@FindBy(xpath = "//a[.='Contacts']") private WebElement contactsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']") private WebElement moreLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement administratorLnk;

	@FindBy(xpath = "//a[.='Sign Out']") private WebElement signoutLnk;

	//utilization

	public WebElement getOrganisationsLink() {
		return organisationsLink;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getAdministratorLnk() {
		return administratorLnk;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}


	public void Logout(WebDriver driver)
	{
		mouseOverOnElement(driver, administratorLnk);
		signoutLnk.click();
	}

}
