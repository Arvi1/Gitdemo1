package practicesExcelReadWrite;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MailAttachingFecility {
	WebDriver driver;
	
	@Test
	public void login(){
	
		//driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://accounts.google.com/");
		
	//	driver.findElement(By.linkText("Gmail")).click();
	
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("annapoornachidurala");
		
		driver.findElement(By.id("next")).click();
				
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys("saibaba143");
		
		driver.findElement(By.id("signIn")).click();
		
		driver.findElement(By.id(":it")).click();
		
		driver.findElement(By.id(":pv")).sendKeys("C:/Users/Anu/Desktop/pray.txt");
		
		driver.findElement(By.xpath("//input[@value='Compose']")).click();
		
	}

}
