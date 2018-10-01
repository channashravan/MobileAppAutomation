

package com.src;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Setup {
	static AppiumDriver driver;
	
	public static String URL="http://srikanthkonda1:P3LDC52rxzo2CpMGgwqA@hub-cloud.browserstack.com/wd/hub";
	
	@Before
	public void launch() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "android");
		caps.setCapability("os_version", "7.1");
		caps.setCapability("deviceName", "Google Pixel");
		caps.setCapability("real_mobile", "true");
		 caps.setCapability("project", "MobileTest");
		 caps.setCapability("build", "1.1");
		 caps.setCapability("name", "Login Test"); 
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("app", "bs://e4aeae506e57c803023e93f55fabe2ba978b0b09");
		//caps.setCapability("app", "bs://e4aeae506e57c803023e93f55fabe2ba978b0b09"); 
		driver = new AppiumDriver(new URL(URL),caps);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test	
	public void CB_userLogin() throws Exception {
		driver.findElement(By.id("com.caringbridge.caringbridge:id/button_sign_in")).click();
		driver.findElement(By.id("com.caringbridge.caringbridge:id/email_signup_edt")).sendKeys("qashravanchanna@gmail.com");
		driver.findElement(By.id("com.caringbridge.caringbridge:id/password_signup_edt")).sendKeys("Kusuma123");
		driver.findElement(By.id("com.caringbridge.caringbridge:id/button_continue_signup")).click();
		Thread.sleep(12000);
	}
	
	@Ignore
	@Test
	public void FB_Login() throws MalformedURLException {
	
		
		driver.findElement(By.id("com.caringbridge.caringbridge:id/button_sign_in")).click();
		driver.findElement(By.id("com.caringbridge.caringbridge:id/facebook_login")).click();
		Set<String> windows = driver.getContextHandles();
		
		for (String window:windows) {
			//System.out.println(window.toString());
			if (window.contains("WEBVIEW")){
			driver.context(window);
			}
			
		}driver.findElement(By.id("m_login_email")).sendKeys("ksrikanth2k9@gmail.com");
		driver.findElement(By.id("m_login_password")).sendKeys("********");
		driver.findElement(By.id("u_0_5")).click();
		driver.findElement(By.id("u_0_9")).click();
		
	//	driver.findElement(By.id("u_0_3")).click();


}
@Ignore
@Test
public void Gmail_Login() {
	driver.findElement(By.id("com.caringbridge.caringbridge:id/button_sign_in")).click();
	driver.findElement(By.id("com.caringbridge.caringbridge:id/google_login")).click();
}


@After
public void TearDown() {
	
	driver.quit();
}

}
