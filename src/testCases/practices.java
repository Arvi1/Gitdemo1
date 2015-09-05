package testCases;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class practices {	
	WebDriver driver;		
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get("http://www.carpoint.com.au/");
		Thread.sleep(4000);
	}	
	@After
	public void shutDown(){		
		driver.quit();				
	}


	@Test
	public void TC3() throws InterruptedException{
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
//		 	select State from the drop down list
				WebElement drpdwnState = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlState"));		
				List<WebElement> optionsState = drpdwnState.findElements(By.tagName("option"));
				System.out.println("State Drop down is clicked");		
				for (WebElement option : optionsState) {
				//	System.out.println(option.getText());
					if(option.getText().contains("Queensland"))
						option.click();					
				}
				Thread.sleep(2000);
//			 select PriceFrom from the drop down list
				WebElement drpdwnPriceFrom = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceFrom"));		
				List<WebElement> optionsPriceFrom = drpdwnPriceFrom.findElements(By.tagName("option"));
				System.out.println("PriceFrom Drop down is clicked");		
				for (WebElement option : optionsPriceFrom) {
				//	System.out.println(option.getText());
					if(option.getText().contains("2,500"))
						option.click();					
				}
				Thread.sleep(2000);
//			select PriceTo from the drop down list
				WebElement drpdwnPriceTo = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceTo"));		
				List<WebElement> optionsPriceTo = drpdwnPriceTo.findElements(By.tagName("option"));
				System.out.println("PriceTo Drop down is clicked");		
				for (WebElement option : optionsPriceTo) {
				//	System.out.println(option.getText());
					if(option.getText().contains("7,500"))
						option.click();					
				}				
				Thread.sleep(2000);
//			click Search Button
				driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_btnSubmit")).click();
				
				Thread.sleep(3000);
		
		WebElement drpdwnSortBy = driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl"));		
		List<WebElement> optionsSortBy = drpdwnSortBy.findElements(By.tagName("option"));
		System.out.println("SortBy Drop down is clicked");		
		for (WebElement option : optionsSortBy) {
			System.out.println(option.getText());
			if(option.getText().contains("Last"))
				option.click();			
			//Thread.sleep(2000);
		}
	}
	//@Test
	public void TC2() throws InterruptedException{
		driver.get("http://www.carpoint.com.au/");
		System.out.println("Home Page launched ");	
		
		WebElement drpdwnMake = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlMake"));		
		List<WebElement> optionsMake = drpdwnMake.findElements(By.tagName("option"));
		System.out.println("make Drop down is clicked");		
		for (WebElement option : optionsMake) {
		//	System.out.println(option.getText());
			if(option.getText().contains("Toyota"))
				option.click();			
			Thread.sleep(2000);
		}	
		
		WebElement drpdwnState = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlState"));		
		List<WebElement> optionsState = drpdwnState.findElements(By.tagName("option"));
		System.out.println("State Drop down is clicked");		
		for (WebElement option : optionsState) {
		//	System.out.println(option.getText());
			if(option.getText().contains("Queensland"))
				option.click();			
			Thread.sleep(2000);
		}
		WebElement drpdwnPriceFrom = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceFrom"));		
		List<WebElement> optionsPriceFrom = drpdwnPriceFrom.findElements(By.tagName("option"));
		System.out.println("PriceFrom Drop down is clicked");		
		for (WebElement option : optionsPriceFrom) {
		//	System.out.println(option.getText());
			if(option.getText().contains("2500"))
				option.click();			
			Thread.sleep(2000);
		}
		WebElement drpdwnPriceTo = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceTo"));		
		List<WebElement> optionsPriceTo = drpdwnPriceTo.findElements(By.tagName("option"));
		System.out.println("PriceTo Drop down is clicked");		
		for (WebElement option : optionsPriceTo) {
		//	System.out.println(option.getText());
			if(option.getText().contains("7500"))
				option.click();			
			Thread.sleep(2000);
		}
		//  ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlState
		//  ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceFrom
		//  ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceTo
	}
	
	//@Test
	public void TC1() throws InterruptedException{
	/*	driver.get("https://www.facebook.com/");
		System.out.println("Home Page launched ");				
		WebElement drpdwnMonth = driver.findElement(By.id("month"));		
		List<WebElement> options = drpdwnMonth.findElements(By.tagName("option"));
		System.out.println("make Drop down is clicked");		
		for (WebElement option : options) {
			if("Mar".equalsIgnoreCase(option.getText()))
				option.click();
			//System.out.println(option.getText());
		}*/	
		driver.get("http://www.carsales.com.au/");
		
		WebElement make = driver.findElement(By.id("MultiPurpose_csnMake"));
		make.click();
		make.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		make.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		make.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		
		
	//	driver.findElement(By.linkText("Toyota")).click();
		Thread.sleep(5000);

		
		
	/*	WebElement drpdwnMake = driver.findElement(By.id("MultiPurpose_csnMake"));				//id("MultiPurpose_csnMake"));		
		List<WebElement> options = drpdwnMake.findElements(By.tagName("option"));
		//List<WebElement> options = drpdwnMake.findElements(By.tagName("li"));

		//System.out.println("make Drop down is clicked");		
		for (WebElement option : options) {
			//if(option.getText().equalsIgnoreCase("Toyota"))
			//	option.click();
			//System.out.println(option.getText());
			System.out.println(option.getText());
			
		}*/

	}
	
}
