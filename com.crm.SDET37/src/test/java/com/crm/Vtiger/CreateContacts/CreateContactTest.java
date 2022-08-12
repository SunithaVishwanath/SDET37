package com.crm.Vtiger.CreateContacts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.BaseClass;
import com.crm.vtiger.objectRepository.ContactsInfoPage;
import com.crm.vtiger.objectRepository.ContactsPage;
import com.crm.vtiger.objectRepository.CreateContactPage;
import com.crm.vtiger.objectRepository.HomePage;

@Listeners(com.crm.comcast.GenericUtilities.ListnerImplTn.class)
public class CreateContactTest extends BaseClass{
	@Test(groups = {"smokeTest","regressionTest"},retryAnalyzer = com.crm.comcast.GenericUtilities.RetryAnalyImp.class)
	public void TocreateContactTest() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//Get a random number
		int randNum = jLib.getRandomNum();

		//Fetch data from excel sheet
		String FirstName = eLib.getDataFromExcel("Contacts", 2, 2)+randNum;

		String LastName = eLib.getDataFromExcel("Contacts", 2, 3)+randNum;

		//click on Contacts link
		HomePage homepage = new HomePage(driver);
		homepage.getContactsLnk().click();
		Assert.fail();
		
		//click on create Contact lookup img
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCnctLkpImg().click();

		//enter the firstname, lastname and click on save btn
		CreateContactPage createContactPage = new CreateContactPage(driver);
		createContactPage.createContact(FirstName, LastName);
		createContactPage.getSaveBtn().click();

		//verify the Organisation Name
		ContactsInfoPage contactsInfoPage = new ContactsInfoPage(driver);
		String name = contactsInfoPage.getContactname().getText();
		
		//Validation using hardAssert
		Assert.assertTrue(name.contains(LastName));
		
		Reporter.log("CreateContactTest is pass",true);
	}
}