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

public class practice1 {

	WebDriver driver;
	String url = "http://www.carpoint.com.au/all-cars/results.aspx?q=%28%28Service%3d[Carsales]%29%26%28%28%28%28%28%28%28SiloType%3d[Brand+new+cars+in+stock]%29|%28SiloType%3d[Dealer+used+cars]%29%29|%28SiloType%3d[Demo+and+near+new+cars]%29%29|%28SiloType%3d[Private+seller+cars]%29%29%26%28Make{%3d}[Hyundai]%29%29%26%28State{%3d}[Queensland]%29%29%26%28Price%3drange[0..5000]%29%29%29&sortby=TopDeal";
	
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
		
		driver.get(url);
		Thread.sleep(5000);
	try {
		
		WebElement drpdwnSort = driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl"));		
		List<WebElement> optionsSort = drpdwnSort.findElements(By.tagName("option"));
		System.out.println("SortBy Drop down is clicked");		
		for (WebElement option : optionsSort) {
			System.out.println(option.getText());
			if(option.getText().contains("Last updated"))
				option.click();					
		}				
		Thread.sleep(2000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	try {
		WebElement drpdwnSortBy = driver.findElement(By.xpath("//div[@class='select-box']"));		
		List<WebElement> optionsSortBy = drpdwnSortBy.findElements(By.tagName("option"));
		System.out.println("SortBy Drop down is clicked");		
		for (WebElement option : optionsSortBy) {
			System.out.println(option.getText());
			if(option.getText().contains("Last"))
				option.click();			
			//Thread.sleep(2000);
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
}
