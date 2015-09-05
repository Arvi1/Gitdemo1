package completeAutomationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndTesting {
	WebDriver driver;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	}
	@Test
	public void mainTest() throws Exception{
		// Launching Home Page
		driver.get("http://www.carpoint.com.au/");
		Thread.sleep(3000);
		
		// Selecting Toyota from Make Drop Down 
		WebElement drpdwnMake = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlMake"));
		List<WebElement> makeOptions = drpdwnMake.findElements(By.tagName("option"));
		for (WebElement option : makeOptions ) {
			if(option.getText().contains("Toyota"))
				option.click();
		}
		Thread.sleep(2000);

		// Selecting Model from Drop Down
		WebElement drpdwnModel = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlModel"));
		List<WebElement> modelOptions = drpdwnModel.findElements(By.tagName("option"));
		for (WebElement option : modelOptions ) {
			if(option.getText().contains("Corolla"))
				option.click();
		}
		Thread.sleep(2000);
		// Selecting Body Type from Drop Down
		WebElement drpdwnBodyType = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlBodyType"));
		List<WebElement> BodyTypeOptions = drpdwnBodyType.findElements(By.tagName("option"));
		for (WebElement option : BodyTypeOptions ) {
			if(option.getText().contains("Sedan"))
				option.click();
		}
		Thread.sleep(2000);
		// Selecting State from Drop Down
		WebElement drpdwnState = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlState"));
		List<WebElement> stateOptions = drpdwnState.findElements(By.tagName("option"));
		for (WebElement option : stateOptions ) {
			if(option.getText().contains("Queensland"))
				option.click();
		}
		Thread.sleep(2000);
		// Selecting Region from Drop Down
		WebElement drpdwnRegion = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlRegion"));
		List<WebElement> egionOptions = drpdwnRegion.findElements(By.tagName("option"));
		for (WebElement option : egionOptions ) {
			if(option.getText().contains("Brisbane All"))
				option.click();
		}
		Thread.sleep(2000);
		// Selecting MaxPrice from Drop Down
		WebElement drpdwnMaxPrice = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceTo"));
		List<WebElement> MaxPriceOptions = drpdwnMaxPrice.findElements(By.tagName("option"));
		for (WebElement option : MaxPriceOptions ) {
			if(option.getText().contains("7,500"))
				option.click();
		}
		Thread.sleep(2000);
		// Submit the form 
		driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_btnSubmit")).click();
		Thread.sleep(5000);
		// Selecting Last Updated from SortBy Drop Down
		driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl")).click();
		driver.findElement(By.linkText("Last updated")).click();
		
		Thread.sleep(3000);
		// Total Cars for Sale
		String sTotCars = driver.findElement(By.xpath("//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[1]/h1/span")).getText();
		System.out.println("Total cars for Sale :" + sTotCars);
		
		// List of Cars and Price Details
		
		String s1 = "//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[";
		String s2 = "]/h2/a";
		String sp1 = "//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[";
		String sp2 = "]/div/div[2]/div[1]/p/a";
		for (int i = 1; i < 15; i++){
			String sCarDetails = driver.findElement(By.xpath(s1+i+s2)).getText();
			System.out.println("Car Details :" + sCarDetails);
			
			String sCarPrice = driver.findElement(By.xpath(sp1+i+sp2)).getText();
			System.out.println("Car Price Details :" + sCarPrice);
		}
		
		
	}
	@After
	public void shutDown(){
		driver.quit();
	}

}
