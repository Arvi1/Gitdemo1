package completeAutomationTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelReadWriteCarpoint {
	String sMake, sModel, sBodyType, sState, sRegion, sPriceMax, sSortBy, sExecute, sResult, sErrorMsg;
;
	String xData[][];
	int xRows, xCols;
	String xPath = "D:\\EclipseProjects\\CarPoint\\Carpoint.xls";
	String xPathRes = "D:\\EclipseProjects\\Carpoint\\Carpoint-Res.xls";
	String xSheet = "Test Cases";
	WebDriver driver;
	
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		xData = readXL(xPath, xSheet);
		xRows = xData.length;
		xCols = xData[0].length;
		driver.get("http://www.carpoint.com.au/");
		Thread.sleep(3000);
	}
	@Test
	public void mainTest() throws Exception{			
		for (int i = 1; i < xRows; i++) {
		sMake = xData[i][0];
		sModel = xData[i][1];
		sBodyType = xData[i][2];
		sState = xData[i][3];
		sRegion = xData[i][4];
		sPriceMax = xData[i][5];
		sSortBy = xData[i][6];
		sExecute = xData[i][7];		
		sResult = xData[i][8];
		sErrorMsg = xData[i][9];
		if (sExecute.equalsIgnoreCase("yes")){			
			try {
				WebElement drpdwnMake = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlMake"));
				List<WebElement> makeOptions = drpdwnMake.findElements(By.tagName("option"));
				for (WebElement option : makeOptions ) {
					if(option.getText().contains(sMake))
						option.click();
				}
				Thread.sleep(2000);
				WebElement drpdwnModel = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlModel"));
				List<WebElement> modelOptions = drpdwnModel.findElements(By.tagName("option"));
				for (WebElement option : modelOptions ) {
					if(option.getText().contains(sModel))
						option.click();
				}
				Thread.sleep(2000);
				WebElement drpdwnBodyType = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlBodyType"));
				List<WebElement> BodyTypeOptions = drpdwnBodyType.findElements(By.tagName("option"));
				for (WebElement option : BodyTypeOptions ) {
					if(option.getText().contains(sBodyType))
						option.click();
				}
				Thread.sleep(2000);
				WebElement drpdwnState = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlState"));
				List<WebElement> stateOptions = drpdwnState.findElements(By.tagName("option"));
				for (WebElement option : stateOptions ) {
					if(option.getText().contains(sState))
						option.click();
				}
				Thread.sleep(2000);
				WebElement drpdwnRegion = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlRegion"));
				List<WebElement> egionOptions = drpdwnRegion.findElements(By.tagName("option"));
				for (WebElement option : egionOptions ) {
					if(option.getText().contains(sRegion))
						option.click();
				}
				Thread.sleep(2000);
				WebElement drpdwnMaxPrice = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceTo"));
				List<WebElement> MaxPriceOptions = drpdwnMaxPrice.findElements(By.tagName("option"));
				for (WebElement option : MaxPriceOptions ) {
					if(option.getText().contains(sPriceMax))
						option.click();
				}
				Thread.sleep(2000);
				driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_btnSubmit")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl")).click();
				driver.findElement(By.linkText(sSortBy)).click();				
				Thread.sleep(3000);
				String sTotCars = driver.findElement(By.xpath("//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[1]/h1/span")).getText();
				System.out.println("Total cars for Sale :" + sTotCars);				
				String s1 = "//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[";
				String s2 = "]/h2/a";
				String sp1 = "//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[";
				String sp2 = "]/div/div[2]/div[1]/p/a";
				try {
					for (int k = 1; k < 6; k++){			
						String sCarDetails = driver.findElement(By.xpath(s1+k+s2)).getText();
						System.out.println("Car Details :" + sCarDetails);			
						String sCarPrice = driver.findElement(By.xpath(sp1+k+sp2)).getText();
						System.out.println("Car Price Details :" + sCarPrice);
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("window.scrollBy(0,100)", "");
						Thread.sleep(2000);
					}
				}	catch (Exception e) {
						System.out.println(e.getMessage());
					}	
						
				try {
					for (int k = 7; k < 9; k++){			
						String sCarDetails = driver.findElement(By.xpath(s1+k+s2)).getText();
						System.out.println("Car Details :" + sCarDetails);			
						String sCarPrice = driver.findElement(By.xpath(sp1+k+sp2)).getText();
						System.out.println("Car Price Details :" + sCarPrice);
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("window.scrollBy(0,100)", "");
						Thread.sleep(2000);
					}
				}	catch (Exception e) {
						String sCarDetails = driver.findElement(By.xpath(s1+9+s2)).getText();
						System.out.println("Car Details :" + sCarDetails);
					}
				try {
					for (int k = 12; k < 16; k++){			
						String sCarDetails = driver.findElement(By.xpath(s1+k+s2)).getText();
						System.out.println("Car Details :" + sCarDetails);			
						String sCarPrice = driver.findElement(By.xpath(sp1+k+sp2)).getText();
						System.out.println("Car Price Details :" + sCarPrice);
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("window.scrollBy(0,100)", "");
						Thread.sleep(2000);
					}
				}	catch (Exception e) {
						System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Execute mode is NO ");
			}	
		
		}
		
	}
	@After
	public void shutDown(){
		driver.quit();
	}
		
	// Method to write into an XL	
	public void writeXL(String sPath, String iSheet, String[][] xData) throws Exception{		    	
	File outFile = new File(sPath);		        
	HSSFWorkbook wb = new HSSFWorkbook();		        
	HSSFSheet osheet = wb.createSheet(iSheet);		        
	int xR_TS = xData.length;		        
	int xC_TS = xData[0].length;		    	
	for (int myrow = 0; myrow < xR_TS; myrow++) {			        
	HSSFRow row = osheet.createRow(myrow);			        
	for (int mycol = 0; mycol < xC_TS; mycol++) {			        	
	HSSFCell cell = row.createCell(mycol);			        	
	cell.setCellType(HSSFCell.CELL_TYPE_STRING);			        	
	cell.setCellValue(xData[myrow][mycol]);			        
	}
			        
	FileOutputStream fOut = new FileOutputStream(outFile);			        
	wb.write(fOut);			        
	fOut.flush();			        
	fOut.close();		    	
	}			
	}
		
	// Method to read XL			
	public String[][] readXL(String sPath, String iSheet) throws Exception{					
	String[][] xData;   					
	File myxl = new File(sPath);                         
	FileInputStream myStream = new FileInputStream(myxl);     
	HSSFWorkbook myWB = new HSSFWorkbook(myStream);     
	HSSFSheet mySheet = myWB.getSheet(iSheet);       
	xRows = mySheet.getLastRowNum()+1;              
	xCols = mySheet.getRow(0).getLastCellNum();    
	xData = new String[xRows][xCols];        
	for (int i = 0; i < xRows; i++) {       
	HSSFRow row = mySheet.getRow(i);							
	for (int j = 0; j < xCols; j++) {      
	HSSFCell cell = row.getCell(j);								
	String value = "-";								
	if (cell!=null){									
	value = cellToString(cell);								
	}								
	xData[i][j] = value; 
	//System.out.println(value);								
	//System.out.print("--");								
	}        							
	}                 
	return xData;			
	}	
	//Change cell type			
	public static String cellToString(HSSFCell cell) { 				
	// This function will convert an object of type excel cell to a string value				
	int type = cell.getCellType();                        				
	Object result;                        				
	switch (type) {                          
					
	case HSSFCell.CELL_TYPE_NUMERIC: //0           
	result = cell.getNumericCellValue();  
	break;                            					
	case HSSFCell.CELL_TYPE_STRING: //1  
	result = cell.getStringCellValue();  
	break;                            					
	case HSSFCell.CELL_TYPE_FORMULA: //2                  
	throw new RuntimeException("We can't evaluate formulas in Java");  
	case HSSFCell.CELL_TYPE_BLANK: //3               
	result = "%";                     
	break;                            					
	case HSSFCell.CELL_TYPE_BOOLEAN: //4   
	result = cell.getBooleanCellValue();   
	break;                            
	case HSSFCell.CELL_TYPE_ERROR: //5      
	throw new RuntimeException ("This cell has an error");  
	default:                  
	throw new RuntimeException("We don't support this cell type: " + type); 
	}          
	return result.toString();    
	}

}
