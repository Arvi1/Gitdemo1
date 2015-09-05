package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	
	WebDriver driver;
	
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void TC1(){
		driver.get("http://www.carsales.com.au/");
		
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("akp2108@gmail.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("Brisbane@123");
		
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.close();
	}
	@After
	public void shutDown(){
		
		driver.quit();
				
	}

}
