package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author SanjayBabu
 *
 */
public class ContactsPage {
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaretion
	@FindBy(xpath = "//img[@title='Create Contact...']") private WebElement cnctLkpImg;


	//utilization
	public WebElement getCnctLkpImg() {
		return cnctLkpImg;
	}
}