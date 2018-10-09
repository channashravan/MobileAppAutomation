package com.src;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.WebGLRenderbuffer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login_iOS {
    static AppiumDriver driver;


    @Before
    public void Launch() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "12.0");
        // caps.setCapability("appPackage","android");
        caps.setCapability("deviceName", "iPhone XR");
        //caps.setCapability("appActivity","android");
        //caps.setCapability("app", "/Users/schanna/Library/Developer/Xcode/DerivedData/CaringBridge-gjkqfuglpuaykbfbmeiwsubcineh/Build/Products/Debug-iphonesimulator/CaringBridge.app");
        //caps.setCapability("app", "/Users/schanna/Library/Developer/Xcode/DerivedData/CaringBridge-bkhmdprgljutkxfmtnhbnneixepm/Build/Products/Debug-iphonesimulator/CaringBridge.app");
       //caps.setCapability("app", "/Users/schanna/Library/Developer/Xcode/DerivedData/CaringBridge-btgefoixnjvdoedszrsqerncrqij/Build/Products/Debug-iphonesimulator/CaringBridge.app");
       caps.setCapability("app", "/Users/schanna/Library/Developer/Xcode/DerivedData/CaringBridge-ectrvqzooqwfkggwncouhcckrqph/Build/Products/Debug-iphonesimulator/CaringBridge.app"); 
       caps.setCapability("app", "/Users/schanna/Library/Developer/Xcode/DerivedData/CaringBridge-ectrvqzooqwfkggwncouhcckrqph/Build/Products/Debug-iphonesimulator/CaringBridge.app");
       
       driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("App launched..");
    }
    
  @Ignore
    @Test
    public void ios_login() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@label='Sign In']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//XCUIElementTypeTextField")).clear();
     	Thread.sleep(3000);
    	driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("qashravanchanna@gmail.com");
    	driver.findElement(By.xpath("//XCUIElementTypeSecureTextField")).sendKeys("Shravan123");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Sign In']")).click();
    	Thread.sleep(8000);
    
    	
    }
    
/*    @Ignore
    @Test
    public void select_Env() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@label='Sign In']")).click();
    	Thread.sleep(5000);
    	TouchAction action = new TouchAction(driver);
    	WebElement login = driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Sign In']"));
    	action.longPress(login).waitAction(Duration.ofSeconds(5)).release().perform();
    	
    	Thread.sleep(2000);
    	WebElement prod_env = driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Production']"));
    	prod_env.click();
    	
    	Thread.sleep(5000);
    	
    }*/
    
    @Ignore
    @Test
    public void profile_authoring() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Authoring']")));
    	    	
    	Thread.sleep(2000);
    	WebElement authoring = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Authoring']"));
    	Assert.assertTrue(authoring.isDisplayed());
      	authoring.click();
       //	WebElement invite_btn = driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Invite']"));
    	//Assert.assertTrue(invite_btn.isDisplayed());
    	
    	//XCUIElementTypeStaticText[@label='Authoring']
    	
    }
   
   //MOBILE-197, 550
    @Ignore
    @Test
    public void journal_creation() throws InterruptedException {
    	profile_authoring();
       	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Post a Journal Entry']")).click();
      	driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Journal Entry Title']")).sendKeys("MyJournal 1");
    	driver.findElement(By.xpath("//XCUIElementTypeTextView")).sendKeys("summary of my journal");
    	driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Post']")).click();
    	Assert.assertTrue("Journal creation confirmation",driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Your Journal Entry has been added']")).isDisplayed());
    	driver.findElementByXPath("//XCUIElementTypeButton[@label='OK']").click();
    	driver.findElementByXPath("//XCUIElementTypeStaticText[@label='MyJournal 1']").click();
    	driver.findElementByXPath("//XCUIElementTypeButton[@label='SiteEllipses']").click();
    	driver.findElementByXPath("//XCUIElementTypeButton[@label='Delete Journal Entry']").click();
    	driver.findElementByXPath("//XCUIElementTypeButton[@label='Yes, Delete']").click();
    	WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Journal Entry Deleted']")));
       	Assert.assertTrue("Jounal delete confirmation",driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal Entry Deleted']")).isDisplayed());
    	driver.findElementByXPath("//XCUIElementTypeButton[@label='OK']").click();
    	    	
    }
    
    @Ignore
    //MOBILE-194
    @Test
    public void journal_amp() throws InterruptedException {
    	
    	profile_authoring();
       	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
       //	Thread.sleep(10000);
    	
    }
    
    @Ignore
    @Test
    public void share_functionality_validation() throws Exception
    {
    	WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")));

    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")).click();
    	driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@label='Untitled'])[1]")).click();
       	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Share']")).click();
    	Thread.sleep(8000);
    	Assert.assertTrue("Share options displayed", driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Cancel']")).isDisplayed());
    	 	//Thread.sleep(10000);
    	
    }
    @Ignore
    @Test
    public void amp_count() throws InterruptedException {
    	
       	profile_authoring();
       	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
       	
       	driver.findElementByXPath("(//XCUIElementTypeCell/XCUIElementTypeButton)[3]").click();
       	//Thread.sleep(10000);
       	Thread.sleep(2000);

       	String count = driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@label,'Heart')])[1]").getText();
       	System.out.println(count);
       	Assert.assertTrue("amp count increment",count.contains("1"));
       	driver.findElementByXPath("(//XCUIElementTypeCell/XCUIElementTypeButton)[3]").click();
       	Thread.sleep(2000);

       	count = driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@label,'Heart')])[1]").getText();
       	Assert.assertTrue("amp count decrement",count.contains("0"));
       	
    }
    //MOBILE-106
    @Ignore
        @Test
    public void edit_site_photo() throws Exception{
    	
    	profile_authoring();
    	driver.findElementByAccessibilityId("editSitePhoto").click();
    	
    	if (driver.findElementByXPath("//*[@label='OK']").isDisplayed()) {
    	driver.findElementByXPath("//*[@label='OK']").click();
    	}
    	
    	driver.findElementByAccessibilityId("photo_cell_1").click();
    	driver.findElementByXPath("//*[@label='Done']").click();
    	//driver.findElement(By.xpath("//XCUIElementTypeImage[@id='editSitePhoto']")).click();
    	Thread.sleep(10000);
    }
    
 //MOBILE-397
    @Ignore   
    @Test
    public void edit_delete_comment() throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Authoring']")));
    	    	
    	Thread.sleep(2000);
    	WebElement following = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='caring bridge']"));
    following.click();
    driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
    driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='1 Comment']")).click();
    driver.findElement(By.xpath("//XCUIElementTypeButton[@label='SiteEllipses']")).click();
    Assert.assertTrue("Edit Comment", driver.findElement(By.xpath("//*[@label='Edit Comment']")).isDisplayed());
    Assert.assertTrue("Delete Comment", driver.findElement(By.xpath("//*[@label='Delete Comment']")).isDisplayed());
    Assert.assertTrue("Cancel Button", driver.findElement(By.xpath("//*[@label='Cancel']")).isDisplayed());
   
    }
    
    //MOBILE-398
    @Ignore
    @Test
    public void comment_and_delete_own_comment() throws Exception {
    		
    	
    	profile_authoring();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='1 Comment']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Post a Comment...']")).sendKeys("Test Commment");
        try {
        driver.hideKeyboard();
        } catch(Exception e) {
        	Assert.fail("keyboard not visible");
        }
        
        driver.findElement(By.xpath("//*[@label='Post']")).click();
        driver.findElement(By.xpath("(//XCUIElementTypeButton[@label='SiteEllipses'])[2]")).click();
        driver.findElement(By.xpath("//*[@label='Delete Comment']")).click();
        Assert.assertTrue("Delete Comment", driver.findElement(By.xpath("//*[@label='1 Comments']")).isDisplayed());
 
 
               
        
    	
    }
    @Ignore
    @Test
    public void jounralEntryScreen_ActionBar() throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")));

    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")).click();
    	
    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//*[@label='1 Comment'])[2]")).click();
    	//driver.hideKeyboard();
    	Thread.sleep(5000);
    	//System.out.println(driver.getPageSource());
    	//Assert.assertTrue("amp",driver.findElement(By.xpath("//XCUIElementTypeImage[@name='AmpGrey']")).isDisplayed());
    	
    	Assert.assertTrue("amp icon",driver.findElementByName("AmpGrey").isEnabled());
    	Assert.assertTrue("share icon",driver.findElementByName("greyShare").isEnabled());
    	Assert.assertTrue("comment icon",driver.findElementByName("commentGrey").isEnabled());
    	
    }
    
    @Ignore
   //MOBILE-316
    @Test
    public void Donation_Card_Validation_iOS() throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")));

    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")).click();
    	
    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
    	Thread.sleep(2000);
    	System.out.println(driver.getPageSource());
    	/*Assert.assertTrue("Donate button",driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Donate in honor of Jon']")).isDisplayed());
    	Assert.assertTrue("Customized message",driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@label,'Honor Jon')]")).isDisplayed());
    	Assert.assertTrue("Tribute Message section",driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Leave a tribute message...']")).isDisplayed());
    	
    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Leave a tribute message...']")).sendKeys("Cambridge is formed from a variety of institutions which include 31 constituent Colleges and over 100 academic departments organised into six schools. Cambridge University Press, a department of the university, is the world's oldest publishing house and the second-largest university press in the world. The university also operates eight cultural and scientific museums, including the Fitzwilliam Museum, as well as a botanic garden. Cambridge's libraries hold a total of around 15 million books, eight million of which are in Cambridge University Library, a legal deposit library.\n" + 
    			"In the fiscal year ending 31 July 2017, the university had a total income of £1.71 billion, of which £458 million was from research grants and contracts.[2] The central university and colleges have a combined endowment of around £4.9 billion, the second largest of any university in the UK.[12] The university is closely linked with the development of the high-tech business cluster known as \"Silicon Fen\". It is a member of numerous associations and forms part of the \"golden triangle\" of leading English universities and Cambridge University Health Partners, an academic health science centre.\n" + 
    			"As of September 2017, Cambridge is ranked the world's second best university by the Times Higher Education World University Rankings,[13] and is ranked 3rd worldwide by Academic Ranking of World Universities, 6th by QS, and 7th by US News.[14][15][16] According to the Times Higher Education ranking, no other institution in the world ranks in the top 10 for as many subjects.[17] The university has educated many notable alumni, including eminent mathematicians, scientists, politicians, lawyers, philosophers, writers, actors and foreign Heads of State. As of August 2018, 116 Nobel Laureates, 11 Fields Medalists, 6 Turing Award winners and 15 British Prime Ministershave been affiliated with Cambridge as students, alumni, faculty or research staff.[1"); 
    //Thread.sleep(10000);
*/    	
    	
    	
    }
    
    @Ignore
    //MOBILE-138
    @Test
    public void Well_Wishes_Screen() throws Exception {
    	profile_authoring();
    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Well Wishes']")).click();
    	Assert.assertTrue(driver.findElementByXPath("//XCUIElementTypeTextView").isDisplayed());
    	//XCUIElementTypeButton[@label='More...']
    	Assert.assertTrue(driver.findElementByXPath("//XCUIElementTypeButton[@label='More...']").isDisplayed());
    	driver.findElementByXPath("//XCUIElementTypeButton[@label='More...']").click();
    //	Thread.sleep(10000);
    	
    	
    }
    
    @Ignore
    //MOBILE-184
 @Test
 public void journalEntry_saveAsDarft_autoSave() throws Exception {
	 profile_authoring();
	 	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
	 	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Post a Journal Entry']")).click();
      	driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Journal Entry Title']")).sendKeys("MyJournal 1");
    	driver.findElement(By.xpath("//XCUIElementTypeTextView")).sendKeys("summary of my journal");
    	driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Cancel']")).click();
    	driver.findElement(By.xpath("//*[@label='Save Draft']")).click();
    	driver.findElement(By.xpath("//*[@label='OK']")).click();
    	Assert.assertTrue(driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@label='Web Draft'])[1]")).isDisplayed());

    	Thread.sleep(10000);
 }
    //MOBILE-486
 @Ignore
 @Test
 public void tributes_screen() throws Exception {
	 WebDriverWait wait = new WebDriverWait(driver,60);
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Hanna Cooper']")));
 	    	
 	Thread.sleep(2000);
 	WebElement hanna_cooper = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Hanna Cooper']"));
 	hanna_cooper.click();
	 driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Tributes']")).click();
	 Assert.assertTrue(driver.findElement(By.xpath("(//XCUIElementTypeCell/XCUIElementTypeStaticText)[1]")).isDisplayed());
 }
 //MOBILE-465
 @Ignore
 @Test
 public void quick_entry_widget_without_keyboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")));

    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Jon Ruiz Site']")).click();
    	
    	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
    	driver.getPageSource();
    	driver.findElement(By.xpath("(//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Untitled'])[1]")).click();
    	driver.findElement(By.xpath("//XCUIElementTypeTextView")).click();
    	//Assert.assertTrue(driver.findElement(By.xpath("//*[@name='Post a Comment...'])[1]")).isDisplayed()); 
    	
    	try {
    		driver.hideKeyboard();
    		
    		//Assert.fail("keyboard is present");
    	} catch(Exception e) {
    		System.out.println("keyboard not present");
    	}
    	//Thread.sleep(10000);
 }
 @Ignore
 //Mobile-429
 @Test
 public void gallery_author_empty_screen() throws Exception {
	 
	 profile_authoring();
	 driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Gallery']")).click();
	 Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Add Photos']")).isDisplayed());
	 Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@label='authorSiteSettings']")).isDisplayed());
	 //Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@label='authorSiteSettings']")).isDisplayed());
	 Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@label='My Sites']")).isDisplayed());
	 driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Add Photos']")).click();
	 driver.findElement(By.xpath("//*[@label='OK']")).click();
	 driver.findElement(By.xpath("//*[@label='Done']")).isDisplayed();
	
 }
 @Ignore
 //Mobile-299
 @Test
 public void Journal_Comment_on_Comment() throws Exception {
	 profile_authoring();
	 driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Journal']")).click();
	 driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@label='0 Comments'])[1]")).click();
	 Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextView/XCUIElementTypeStaticText")).isDisplayed());
	// Assert.assertFalse(driver.findElement(By.xpath("*[@label='Post']")).isDisplayed());
	 driver.findElement(By.xpath("//XCUIElementTypeTextView/XCUIElementTypeStaticText")).sendKeys("new comment on comment");
	Thread.sleep(5000);
	 Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Post']")).isDisplayed());
	 driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Post']")).click();
	// Assert.assertTrue(driver.findElement(By.xpath("XCUIElementTypeStaticText[@label='new comment on comment']")).iDisplayed());
	driver.findElement(By.xpath("(//XCUIElementTypeButton[@label='SiteEllipses'])[2]")).click();
	driver.findElement(By.xpath("//*[@label='Delete Comment']")).click();
	
 }
 

 
 
 
    @After
    public void tearDown() {    	
    	driver.quit();
    	System.out.println("App closed");
     	
    	
    }

}
