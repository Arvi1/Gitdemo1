package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectMake {	
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
// 	select State from the drop down list
		WebElement drpdwnState = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlState"));		
		List<WebElement> optionsState = drpdwnState.findElements(By.tagName("option"));
		System.out.println("State Drop down is clicked");		
		for (WebElement option : optionsState) {
		//	System.out.println(option.getText());
			if(option.getText().contains("Queensland"))
				option.click();					
		}
		Thread.sleep(2000);
//	 select PriceFrom from the drop down list
		WebElement drpdwnPriceFrom = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceFrom"));		
		List<WebElement> optionsPriceFrom = drpdwnPriceFrom.findElements(By.tagName("option"));
		System.out.println("PriceFrom Drop down is clicked");		
		for (WebElement option : optionsPriceFrom) {
		//	System.out.println(option.getText());
			if(option.getText().contains("2,500"))
				option.click();					
		}
		Thread.sleep(2000);
//	select PriceTo from the drop down list
		WebElement drpdwnPriceTo = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceTo"));		
		List<WebElement> optionsPriceTo = drpdwnPriceTo.findElements(By.tagName("option"));
		System.out.println("PriceTo Drop down is clicked");		
		for (WebElement option : optionsPriceTo) {
		//	System.out.println(option.getText());
			if(option.getText().contains("7,500"))
				option.click();					
		}				
		Thread.sleep(2000);
//	click Search Button
		driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_btnSubmit")).click();
		
		Thread.sleep(3000);
		
// slecting the sort by drop down
		try {
		driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl")).sendKeys("Last updated");
		driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl")).click();
		Thread.sleep(3000);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			
			WebElement drpdwnSort = driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl"));		
			List<WebElement> optionsSort = drpdwnSort.findElements(By.tagName("li"));
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
			List<WebElement> optionsSortBy = drpdwnSortBy.findElements(By.tagName("li"));
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
		
	
		String sTitle = driver.findElement(By.xpath("//div[contains(@class,'result-set-header')]/h1")).getText();
		System.out.println(sTitle);
		/*try {
		
		System.out.println(driver.findElement(By.xpath("//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/h2/a")).getText());
		System.out.println(driver.findElement(By.xpath("//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[0]/h2/a")).getText());
		System.out.println(driver.findElement(By.xpath("//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/h2/a")).getText());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
	}	
	
	
}
