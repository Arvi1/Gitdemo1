package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortBy {
WebDriver driver;	
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}	
	@After
	public void shutDown(){		
		driver.quit();				
	}
	@Test
	public void TC1() throws InterruptedException{
		driver.get("http://www.carpoint.com.au/");
		System.out.println("Home Page launched ");

// select Make from the drop down list
		WebElement drpdwnMake = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlMake"));		
		List<WebElement> optionsMake = drpdwnMake.findElements(By.tagName("option"));
		System.out.println("Make Drop down is clicked");		
		for (WebElement option : optionsMake) {
		//	System.out.println(option.getText());
			if(option.getText().contains("Toyota"))
				option.click();					
		}
		Thread.sleep(2000);
//	click Search Button
		driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_btnSubmit")).click();
		Thread.sleep(3000);
//	click on Sort By drop down
		driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl")).click();
		driver.findElement(By.linkText("Last updated")).click();
		Thread.sleep(2000);
// printing the header 
		String sTitle = driver.findElement(By.xpath("//div[contains(@class,'result-set-header')]/h1")).getText();
		System.out.println(sTitle);
	}
}
