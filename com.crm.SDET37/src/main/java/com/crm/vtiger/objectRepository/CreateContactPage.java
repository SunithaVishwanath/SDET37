package com.crm.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	//initialisation
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaretion
	@FindBy(name = "firstname") private WebElement firstnameEdt;

	@FindBy(name = "lastname") private WebElement lastnameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveBtn;

	@FindBy(xpath = "//img[@title='Select']") private WebElement selectLkpImg;

	@FindBy(name = "search_text") private WebElement searchOrgEdt;

	@FindBy(name = "search") private WebElement searchNowBtn;
	//utilisation
	public WebElement getFirstnameEdt() {
		return firstnameEdt;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public void createContact(String enterFirstName,String enterLastName)
	{
		firstnameEdt.sendKeys(enterFirstName);
		lastnameEdt.sendKeys(enterLastName);
	}
	/**
	 * 
	 * @param driver
	 * @param orgname
	 */
	public void selectOrg(WebDriver driver,String orgname)
	{
		selectLkpImg.click();
		switchTowindow(driver,"Accounts&action");
		searchOrgEdt.sendKeys(orgname);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
		switchTowindow(driver, "Contacts&action");
	}
}
