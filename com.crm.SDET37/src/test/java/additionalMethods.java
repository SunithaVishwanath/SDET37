import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class additionalMethods {

	@Test()
	public void dog()
	{
		Reporter.log("bow bow",true);
	}
	
	@Test()
	public void cat()
	{
		Reporter.log("meow meow",true);
		
	}
	
	@Test(dependsOnMethods = {"dog","cat"})
	public void snake()
	{
		Reporter.log("buss buss",true);
	}
}
