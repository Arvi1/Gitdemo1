package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tc2 {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.carsales.com.au/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testUntitled() throws Exception {
	    driver.get(baseUrl);
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("a.select-display")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.id("MultiPurpose_csnMake")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.cssSelector("#MultiPurpose_csnModel > div.select-box > a.select-display > span.text")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.linkText("Price From:Min")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.linkText("To:Max")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.linkText("Location:Any location")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.id("csnSearchButton")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    
	  }

	
	}
