package com.crm.Vtiger.CreateContacts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.GenericUtilities.BaseClass;
import com.crm.vtiger.objectRepository.ContactsInfoPage;
import com.crm.vtiger.objectRepository.ContactsPage;
import com.crm.vtiger.objectRepository.CreateContactPage;
import com.crm.vtiger.objectRepository.CreateOrganisationPage;
import com.crm.vtiger.objectRepository.HomePage;
import com.crm.vtiger.objectRepository.OrganisationInfoPage;
import com.crm.vtiger.objectRepository.OrganisationPage;
/**
 * 
 * @author SanjayBabu
 *
 */
@Listeners(com.crm.comcast.GenericUtilities.ListnerImplTn.class)
public class CreateContactWithOrganisationTest extends BaseClass{

	@Test(retryAnalyzer = com.crm.comcast.GenericUtilities.RetryAnalyImp.class)
	public void createContactWithOrganisationTest() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//Get a random number
		int randNum = jLib.getRandomNum();

		//Fetch the firstname from excel
		String FirstName = eLib.getDataFromExcel("Contacts", 2, 2)+randNum;

		//Fetch the last name from excel
		String LastName = eLib.getDataFromExcel("Contacts", 2, 3)+randNum;

		//Fetch the orgname from excel
		String orgName = eLib.getDataFromExcel("Organisations", 1, 2)+randNum;
		
		//click on Organisation link
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationsLink().click();

		//click on CreateOrganisation LookUp Img
		OrganisationPage organisationPage = new OrganisationPage(driver);
		organisationPage.getOrganisationLkpImg().click();

		//enter the Organisation name and click on save btn
		CreateOrganisationPage createOrganisationPage = new CreateOrganisationPage(driver);
		createOrganisationPage.createOrg(orgName);
		createOrganisationPage.getSaveBtn().click();

		//verify whether the Organisation is created or not
		OrganisationInfoPage organisationInfoPage = new OrganisationInfoPage(driver);
		String name = organisationInfoPage.getOrgname().getText();
		
		Assert.assertTrue(name.contains(orgName),"Test is fail");
		
		Reporter.log("oranisation is created",true);

		//click on contacts link
		homePage.getContactsLnk().click();

		//click on create contact lookup img
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCnctLkpImg().click();

		//enter the firstname and lastname
		CreateContactPage createContactPage = new CreateContactPage(driver);
		createContactPage.createContact(FirstName, LastName);
		createContactPage.selectOrg(driver, orgName);
		createContactPage.getSaveBtn().click();

		//verify
		ContactsInfoPage contactsInfoPage = new ContactsInfoPage(driver);
		String contactName = contactsInfoPage.getContactname().getText();
		
		//Validation using SoftAssert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(contactName.contains(LastName));
		
		Reporter.log("CreateContactWithOrganisationTest is pass");
		softAssert.assertAll();
	}
}