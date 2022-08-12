package com.crm.Vtiger.Organisation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.GenericUtilities.BaseClass;
import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.IConstants;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectRepository.CreateOrganisationPage;
import com.crm.vtiger.objectRepository.HomePage;
import com.crm.vtiger.objectRepository.LoginPage;
import com.crm.vtiger.objectRepository.OrganisationInfoPage;
import com.crm.vtiger.objectRepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author SanjayBabu
 *
 */
@Listeners(com.crm.comcast.GenericUtilities.ListnerImplTn.class)
public class ToCreateOrganisationTest extends BaseClass{
@Test(groups = {"smokeTest","regressionTest"})
	public void AcreateOrganisationTest() throws EncryptedDocumentException, FileNotFoundException, IOException{

		//To get the Random number
		int randNum = jLib.getRandomNum();

		//Fetch data from excel sheet
		String orgName = eLib.getDataFromExcel("Organisations", 1,2)+randNum;

		//click on Organisations link
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationsLink().click();
		
		//click on create Organisation lookup img
		OrganisationPage organisationPage = new OrganisationPage(driver);
		organisationPage.getOrganisationLkpImg().click();

		//enter the Organisation name and click on save btn
		CreateOrganisationPage createOrganisationPage = new CreateOrganisationPage(driver);
		createOrganisationPage.createOrg(orgName);
		createOrganisationPage.getSaveBtn().click();


		//verify the Organisation Name
		OrganisationInfoPage organisationInfoPage = new OrganisationInfoPage(driver);
		String org = organisationInfoPage.getOrgname().getText();

		//validation using softAssert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.contains(orgName), "test is fail");	
		Reporter.log("CreateOrganisationTest is pass",true);		
		softAssert.assertAll();
	}
}