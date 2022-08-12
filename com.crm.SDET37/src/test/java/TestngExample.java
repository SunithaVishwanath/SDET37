import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngExample {
	@BeforeSuite
	public void bs()
	{
		System.out.println("bfrSuite");
	}

	@AfterSuite
	public void as()
	{
		System.out.println("atrSuite");
	}
	@BeforeTest
	public void bt()
	{
		System.out.println("btrTest");
	}

	@AfterTest
	public void at()
	{
		System.out.println("aftTest");
	}

	@BeforeClass
	public void bc()
	{
		System.out.println("bfrclass");
	}

	@AfterClass
	public void ac()
	{
		System.out.println("aftClass");
	}

//	@BeforeGroups
//	public void bg()
//	{
//		System.out.println("bfrGroups");
//	}
//
//	@AfterGroups
//	public void ag()
//	{
//		System.out.println("afrGroups");
//	}

	@BeforeMethod
	public void bm1()
	{
		System.out.println("bfrMtd1");
	}
	@BeforeMethod
	public void am2()
	{
		System.out.println("bfrMtd2");
	}
	
	
	@AfterMethod
	public void am()
	{
		System.out.println("aftmtd");
	}
	
	
	@Test
	public void test1()
	{
		System.out.println("@TestMethod1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("@TestMthod2");
	}
}
