package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileAttach {
	
	@Test
	public void mainTest() throws Exception{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get("http://docs.seleniumhq.org/");
		System.out.println(driver.findElement(By.linkText("Selenium WebDriver")).getCssValue("color"));
		System.out.println(driver.findElement(By.linkText("Selenium WebDriver")).getCssValue("background-color"));
		
		
	/*	driver.get("http://laoap.hudson.com/applyonline?advertid=450453");
		
		WebElement upLoad = driver.findElement(By.id("applicant_first_name"));
		
		upLoad.sendKeys("Selenium");
		
		
		Thread.sleep(3000);
		
		
		System.out.println(upLoad.getAttribute("value"));
		
		List<WebElement> frameList = driver.findElements(By.xpath("//iframe"));
		
		System.out.println(frameList.size());
		*/
		//driver.findElement(By.id("fRS")).sendKeys("E:/QC/pray.txt");
	}

}
