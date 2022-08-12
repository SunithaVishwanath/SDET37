package com.crm.Vtiger.Organisation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.BaseClass;
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
public class CreateOrgWithIndustryAndType extends BaseClass{
@Test
	public void createOrgWithIndustryAndType() throws EncryptedDocumentException, FileNotFoundException, IOException{

		//Get a random number
		int randNum = jLib.getRandomNum();

		//Fetch data from excel sheet
		String orgName = eLib.getDataFromExcel("Organisations", 1, 2)+randNum;

		//Fetch industry from excel
		String industry = eLib.getDataFromExcel("Organisations", 4, 3);

		//Fetch type from excel
		String Type = eLib.getDataFromExcel("Organisations", 4, 4);


		//click on Organisations link
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationsLink().click();

		//click on create Organisation lookup img
		OrganisationPage organisationPage = new OrganisationPage(driver);
		organisationPage.getOrganisationLkpImg().click();

		//enter the Organisation name, select industry, select type
		CreateOrganisationPage createOrganisationPage = new CreateOrganisationPage(driver);
		createOrganisationPage.createOrg(orgName);
		createOrganisationPage.selectIndustry(industry);
		createOrganisationPage.selectType(Type);
		createOrganisationPage.getSaveBtn().click();

		//validation using softAssert
		OrganisationInfoPage organisationInfoPage = new OrganisationInfoPage(driver);
		String name = organisationInfoPage.getOrgname().getText();
		Assert.assertTrue(name.contains(orgName));
		
		Reporter.log("Organisation with industry and type is pass");
	}
}