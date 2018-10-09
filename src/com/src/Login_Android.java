package com.src;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login_Android {
    static AndroidDriver driver;
    public static String URL="http://srikanthkonda1:P3LDC52rxzo2CpMGgwqA@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void Launch() throws Exception {
    	/*---------------- Browserstack---------------------*/
    	
    	/*DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "android");
		caps.setCapability("os_version", "7.1");
		caps.setCapability("deviceName", "Google Pixel");
		caps.setCapability("real_mobile", "true");
		 caps.setCapability("project", "MobileTest");
		 caps.setCapability("build", "1.1");
		 caps.setCapability("name", "Login Test"); 
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("app", "bs://d56990707bfdc22fd8bf6b95bedaad2ce5817b53");
		
 	driver = new AndroidDriver(new URL(URL),caps); */
    	/*----------------- physical device/simulator ------------*/
    	
       DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "5.1.1");
        caps.setCapability("deviceName", "emulator");
        caps.setCapability("app","/Users/schanna/Downloads/com.caringbridge.caringbridge-v1.9.1-SNAPSHOT.apk");
        driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        /*--------------------------------------------------------*/
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        System.out.println("App launched..");
    }
    @Ignore
    @Test
    public void Login() throws Exception {
       
        driver.findElement(By.id("com.caringbridge.caringbridge:id/button_sign_in")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("com.caringbridge.caringbridge:id/email_signup_edt")).sendKeys("qashravanchanna@gmail.com");
        driver.findElement(By.id("com.caringbridge.caringbridge:id/password_signup_edt")).sendKeys("Shravan123");
        //driver.hideKeyboard();
        driver.findElement(By.id("com.caringbridge.caringbridge:id/button_continue_signup")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.id("com.caringbridge.caringbridge:id/navigation_my_account")).isDisplayed());
       /* driver.findElement(By.id("com.caringbridge.caringbridge:id/navigation_my_account")).click();
        driver.findElement(By.id("com.caringbridge.caringbridge:id/logoutButton")).click();
        Assert.assertTrue(driver.findElement(By.id("com.caringbridge.caringbridge:id/button_sign_in")).isDisplayed());*/


    }
    @Ignore
    @Test
    public void profile_Authoring() throws Exception  {
    	Login();
    	//php_share_invite_button_textview,//android.widget.TextView[@text='Invite'],
    	//
    	Thread.sleep(3000);
    WebElement authoring_btn = driver.findElement(By.xpath("//android.widget.TextView[@text='Authoring']"));
    authoring_btn.click();
    Thread.sleep(5000);
   Assert.assertTrue(driver.findElement(By.id("com.caringbridge.caringbridge:id/php_share_button_textview")).isDisplayed());
   Thread.sleep(5000);
      	
    	
    }
    @Ignore
    //MOBILE-161
    @Test
    public void journal_entry() throws Exception {
    	Login();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Authoring']")).click();
    	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
    	Assert.assertTrue("Journal Entry screen exists", driver.findElementById("com.caringbridge.caringbridge:id/journal_entry_title_textview").isDisplayed());
    	
    	
    }
    //MOBILE-267, MOBILE-551
    @Ignore
   @Test
    public void new_journal_entry_screen_validation() throws Exception {
    	
    	Login();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Authoring']")).click();
    	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
    	driver.findElementById("com.caringbridge.caringbridge:id/journal_entry_title_textview").click();
    	driver.findElementById("author_journal_entry_author_title").click();
    	Assert.assertTrue("profile image", driver.findElementById("com.caringbridge.caringbridge:id/journal_info_component_author_image").isDisplayed());
    	Assert.assertTrue("author name", driver.findElementById("com.caringbridge.caringbridge:id/journal_info_component_author_name").isDisplayed());
    	Assert.assertTrue("Add Photos image", driver.findElementById("com.caringbridge.caringbridge:id/photo_img").isDisplayed());
    	Assert.assertTrue("Add Photos", driver.findElement(By.xpath("//android.widget.TextView[@text='Add Photos']")).isDisplayed());
    	driver.hideKeyboard();
    }
    @Ignore
   //MOBILE-271
   @Test
   public void journal_screen_validation() throws Exception {
	   Login();
   	driver.findElement(By.xpath("//android.widget.TextView[@text='Authoring']")).click();
   	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
   	Assert.assertTrue("journal title", driver.findElementById("com.caringbridge.caringbridge:id/journal_title_textview").isDisplayed());
   	Assert.assertTrue("time stamp", driver.findElementById("com.caringbridge.caringbridge:id/posted_date_journal_text_view").isDisplayed());
   	Assert.assertTrue("Activity Type & Journal author", driver.findElementById("com.caringbridge.caringbridge:id/journal_info_textview").isDisplayed());
   	Assert.assertTrue("amp icon", driver.findElementById("com.caringbridge.caringbridge:id/iampIcon").isDisplayed());
   	Assert.assertTrue("Cooment Count", driver.findElementById("com.caringbridge.caringbridge:id/journal_site_activity_reply_text").isDisplayed());
   	driver.findElementById("com.caringbridge.caringbridge:id/iampIcon").click();
   	Assert.assertTrue("amp count increment",driver.findElementById("com.caringbridge.caringbridge:id/journal_list_journal_amp_count").getText().equals("1 Heart"));
   	driver.findElementById("com.caringbridge.caringbridge:id/iampIcon").click();
   	Assert.assertTrue("amp count decrement",driver.findElementById("com.caringbridge.caringbridge:id/journal_list_journal_amp_count").getText().equals("0 Hearts"));
   
	   
   }
    @Ignore
    //MOBILE-289
    @Test
    public void view_journal_entry_screen() throws Exception {
    	Login();
       	driver.findElement(By.xpath("//android.widget.TextView[@text='Following']")).click();
       	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
       	Assert.assertTrue("Donate button",driver.findElementById("com.caringbridge.caringbridge:id/donate_to_author_view").isDisplayed());
       	Assert.assertTrue("leave tribute message",driver.findElementById("com.caringbridge.caringbridge:id/leave_a_tribute_message_edittext_donations_card").isDisplayed());
       	Assert.assertTrue("Donate widgetr",driver.findElementById("com.caringbridge.caringbridge:id/donations_card_journals_list_view").isDisplayed());
       	List<WebElement>  cards = driver.findElementsById("com.caringbridge.caringbridge:id/journal_card_constraintlayout");   
       	
       	
 /*      	for (WebElement card: cards) {
       		card.click();
       		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
       	}*/
       
    	
    }
    
   
   @Ignore
    @Test
    public void DonationCard_Validation() throws Exception {
    	Login();
       	driver.findElement(By.xpath("//android.widget.TextView[@text='Following']")).click();
       	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
       	driver.findElementById("com.caringbridge.caringbridge:id/journal_card_constraintlayout").click();
       	Assert.assertTrue("Donate Today",driver.findElementById("com.caringbridge.caringbridge:id/donate_to_author_view").isDisplayed());
       	Assert.assertTrue("personalized message", driver.findElementById("com.caringbridge.caringbridge:id/donate_to_cb_text_donation_card").getText().contains("Jon"));
       	
       	driver.findElementById("com.caringbridge.caringbridge:id/leave_a_tribute_message_edittext_donations_card").sendKeys("test donation");
       	
       driver.findElementById("com.caringbridge.caringbridge:id/donate_to_author_view").click();
    }
   
   @Ignore
   //MOBILE-321
    @Test
    public void amp_count() throws Exception {
    	Login();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Authoring']")).click();
    	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
    	
    	//com.caringbridge.caringbridge:id/journal_list_journal_amp_count, com.caringbridge.caringbridge:id/iampIcon
    	driver.findElementByXPath("(//android.widget.ImageView[@resource-id='com.caringbridge.caringbridge:id/iampIcon'])[1]").click();
    	Thread.sleep(2000);
    	String count = driver.findElementByXPath("(//android.widget.TextView[@resource-id='com.caringbridge.caringbridge:id/journal_list_journal_amp_count'])[1]").getText();
    	Assert.assertTrue("amp count increment ", count.contains("1"));
    	
        driver.findElementByXPath("(//android.widget.ImageView[@resource-id='com.caringbridge.caringbridge:id/iampIcon'])[1]").click();
        Thread.sleep(2000);
    	count = driver.findElementByXPath("(//android.widget.TextView[@resource-id='com.caringbridge.caringbridge:id/journal_list_journal_amp_count'])[1]").getText();
    	Assert.assertTrue("amp count decrement ", count.contains("0"));
    	
    	
    }
   @Ignore
   //Mobile-429
   @Test
   public void journal_Social_Share_ActionBar() throws Exception {
  	
  		Login();
       	driver.findElement(By.xpath("//android.widget.TextView[@text='Following']")).click();
       	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
       	driver.findElementById("com.caringbridge.caringbridge:id/journal_card_constraintlayout").click();
      	driver.findElementById("com.caringbridge.caringbridge:id/journal_action_bar_share_img").click();
      	
   
   }
    

   /* @Test
    public void facebokLogin() {
        //com.caringbridge.caringbridge:id/facebook_login
        //driver.findElement(By.id("com.caringbridge.caringbridge:id/facebook_login")).click();
    } */
   @Ignore
   @Test
   public void journalEntryScreen_displayCommentsList_Author() throws Exception {
	   Login();
	   driver.findElement(By.xpath("//android.widget.TextView[@text='Authoring']")).click();
   	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
   	driver.findElementById("com.caringbridge.caringbridge:id/share_journal_list_journal_item").click();
   	//driver.findElementById("com.caringbridge.caringbridge:id/journal_action_bar_comment_img").click();
   	driver.findElementById("com.caringbridge.caringbridge:id/comment_ellipses").click();
   	Assert.assertTrue(driver.findElementById("com.caringbridge.caringbridge:id/delete_comment_dialog").isDisplayed());
   	Assert.assertTrue(driver.findElementById("com.caringbridge.caringbridge:id/edit_comment_dialog").isDisplayed());
  	
   	
   }
   @Test
   public void journalEntryScreen_displayCommentsList_Visitor() throws Exception {
	   Login();
	   driver.findElement(By.xpath("//android.widget.TextView[@text='Following']")).click();
      	driver.findElementByXPath("//android.widget.TextView[@text='Journal']").click();
   	driver.findElementById("com.caringbridge.caringbridge:id/journal_card_constraintlayout").click();
   	//driver.findElementById("com.caringbridge.caringbridge:id/journal_action_bar_comment_img").click();
   	driver.findElementById("com.caringbridge.caringbridge:id/comment_ellipses").click();
   	Assert.assertTrue(driver.findElementById("com.caringbridge.caringbridge:id/delete_comment_dialog").isDisplayed());
   	Assert.assertTrue(driver.findElementById("com.caringbridge.caringbridge:id/edit_comment_dialog").isDisplayed());
   	
   	
   	
   }

    @After
    public void teardown() {
        driver.quit();
        System.out.println("app closed..");

    }
}
