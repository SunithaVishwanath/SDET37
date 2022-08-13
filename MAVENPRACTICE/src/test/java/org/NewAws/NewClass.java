package org.NewAws;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewClass {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//Step1: Enter the URL
		URL url=new URL("http://3.139.106.240:4444/wd/hub");
		
		//Step2: Set desired capabilities
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		//Step3: Load remote web driver
		RemoteWebDriver driver=new RemoteWebDriver(url, cap);
		
		//Step4: Load the app
		driver.get("https://gmail.com");
	}

}
