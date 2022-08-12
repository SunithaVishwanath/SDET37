package com.crm.comcast.GenericUtilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.vtiger.objectRepository.HomePage;
import com.crm.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author SanjayBabu
 *
 */
public class BaseClass {

	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	/**
	 * connecting to DB
	 */
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void dbConfig()
	{
		dLib.connectToDB();
	}
	
	/**
	 * launching browser
	 * @throws IOException
	 */
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void launchTheBrowser() throws IOException
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = WebDriverManager.chromedriver().create();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=WebDriverManager.firefoxdriver().create();
		}else {
			WebDriverManager.chromedriver().create();
		}
		System.out.println("browser is launched");
		//enter the url
		sdriver=driver;
		driver.get(URL);
		//maximize the window
		wLib.maximizeTheWindow(driver);
		//implicit wait
		wLib.waitTillPageGetsLoad(driver);
	}
	
	/**
	 * logging into Application
	 * @throws IOException
	 */
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void loginToApp() throws IOException
	{
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("successfully logged into application");
	}
	
	/**
	 * logout from application
	 */
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void logoutFromApp()
	{
		HomePage homepage = new HomePage(driver);
		homepage.Logout(driver);
		
		System.out.println("logged out from application");
	}
	
	/**
	 * closeing browser
	 */
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void closeTheBrowser()
	{
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	/**
	 * closeing DB
	 */
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void closeDbConn()
	{
		dLib.closeDB();
	}
}
