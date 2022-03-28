package newpackage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Interview {
	
	WebDriver driver;
	
	// Set up browser setting and open the application
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Soft\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Opened the application
		
		driver.get("https://staging.tinyserver.info/auth");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void Login() throws InterruptedException {
		
		try {
			boolean searchTextBoxBoolean = driver.findElement(By.xpath("//input[@data-cucumber='input-login-email']")).isDisplayed();
			System.out.println(searchTextBoxBoolean);
			WebElement searchemail = driver.findElement(By.xpath("//input[@data-cucumber='input-login-email']"));
			searchemail.clear();
			searchemail.sendKeys("lecongtoan432@gmail.com");
			searchemail.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			WebElement searchpassw = driver.findElement(By.xpath("//input[@data-cucumber='input-login-password']"));
			searchpassw.clear();
			searchpassw.sendKeys("Aashdkjasd@1ajsd");
			//searchpassw.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//span[text()='Sign in']")).click();
			Thread.sleep(10000);
			
			
			WebElement setting = driver.findElement(By.xpath("//span[text()='Settings']"));
			boolean searchsetting = setting.isEnabled();
			System.out.println(searchsetting);
			if (searchsetting == true){
				Actions actions = new Actions(driver);
				actions.moveToElement(setting).click().build().perform();
			}
			else {
				System.out.println("Failed to click to setting");
			}
			Thread.sleep(1000);
			
			WebElement addPeople = driver.findElement(By.xpath("//span[text()='Add People']"));
			boolean searchaddPeople = setting.isEnabled();
			System.out.println(searchaddPeople);
			if (searchaddPeople == true){
				Actions actions = new Actions(driver);
				actions.moveToElement(addPeople).click().build().perform();
			}
			else {
				System.out.println("Failed to click to Add People");
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void AddSomeUsers() throws InterruptedException {
		
		try {
				
			//add some users 1 into list
			Thread.sleep(5000);		
			WebElement addFirstName = driver.findElement(By.xpath("//input[@field='firstName' and @refkey='1']"));
			addFirstName.clear();
			addFirstName.sendKeys("Testuser1");
			Thread.sleep(1000);
			
			WebElement addLastName = driver.findElement(By.xpath("//input[@field='lastName' and @refkey='1']"));
			addLastName.clear();
			addLastName.sendKeys("Testuser1");
			Thread.sleep(1000);
			
			WebElement addEmail = driver.findElement(By.xpath("//input[@field='email' and @refkey='1']"));
			addEmail.clear();
			addEmail.sendKeys("Testuser1@testmail.com");
			
			//add some users 2 into list
			Thread.sleep(5000);		
			WebElement addFirstName2 = driver.findElement(By.xpath("//input[@field='firstName' and @refkey='2']"));
			addFirstName2.clear();
			addFirstName2.sendKeys("Testuser2");
			Thread.sleep(1000);
			
			WebElement addLastName2 = driver.findElement(By.xpath("//input[@field='lastName' and @refkey='2']"));
			addLastName2.clear();
			addLastName2.sendKeys("Testuser2");
			Thread.sleep(1000);
			
			WebElement addEmail2 = driver.findElement(By.xpath("//input[@field='email' and @refkey='2']"));
			addEmail2.clear();
			addEmail2.sendKeys("Testuser2@testmail.com");
			
			driver.findElement(By.xpath("//span[@class='Button__text___13OYb' and text()='Add People']")).click();
			Thread.sleep(2000);
			
		    try {
		    	boolean checkCongratulations = driver.findElement(By.xpath("//div[contains(text(), 'Congratulations')]")).isDisplayed();
				if (checkCongratulations == true) {
					System.out.println("Add uses sucessfully");
				}
				else {
					Assert.fail("Add uses unsucessfully");
				}
				
		    } catch (NoSuchElementException e) {
		        Assert.fail("The current date is not displayed! " + e.getMessage());
		    }

			System.out.println("Test Body Completed");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		
	
	//tear down the setup after test completes
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}
