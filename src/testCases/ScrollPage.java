package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPage {
	WebDriver driver;
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void mainTest() throws Exception{
		driver.get("http://www.carpoint.com.au/");
		
		System.out.println(driver.getTitle());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.linkText("Terms & Conditions")).isDisplayed());
	}
	

}
