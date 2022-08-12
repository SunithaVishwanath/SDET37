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
public class OrganisationPage {

	//initialisation
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaretion
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement organisationLkpImg;

	//utilization
	public WebElement getOrganisationLkpImg() {
		return organisationLkpImg;
	}

}
