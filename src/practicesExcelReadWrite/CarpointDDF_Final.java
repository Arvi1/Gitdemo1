package practicesExcelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CarpointDDF_Final {

	WebDriver driver;
	String xData[][];
	int xRows, xCols;
	String xlPath, xlRes_Path;
	
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		xlPath = "D:\\EclipseProjects\\CarPoint\\CarPoint.xls";
		xlRes_Path ="D:\\EclipseProjects\\CarPoint\\CarPoint-Res.xls";
		xlRead(xlPath);
		
	}
	
	@Test
	public void MyTest() throws Exception{
		String sMake, sModel, sBodyType, sState, sRegion, sPriceMin, sPriceMax, sSortBy, sReult, sError,sExecute;
		for (int i = 1; i < xRows; i++){
			sMake = xData[i][0];
			sModel = xData[i][1];
			sBodyType = xData[i][2];
			sState = xData[i][3];
			sRegion = xData[i][4];
			sPriceMin = xData[i][5];
			sPriceMax = xData[i][6];
			sSortBy = xData[i][7];
			sExecute = xData[i][8];
			sReult = "Pass";
			sError = "No Error";
			if (sExecute.equalsIgnoreCase("Yes")) {
				try {
					driver.get("http://www.carpoint.com.au/");
					Thread.sleep(3000);
					WebElement drpdwnMake = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlMake"));
					List<WebElement> makeOptions = drpdwnMake.findElements(By.tagName("option"));
					for (WebElement option : makeOptions ) {
						if(option.getText().contains(sMake))
							option.click();
					}
					Thread.sleep(2000);
					// Selecting Model from Drop Down
					WebElement drpdwnModel = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlModel"));
					List<WebElement> modelOptions = drpdwnModel.findElements(By.tagName("option"));
					for (WebElement option : modelOptions ) {
						if(option.getText().contains(sModel))
							option.click();
					}
					Thread.sleep(2000);
					// Selecting Body Type from Drop Down
					WebElement drpdwnBodyType = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlBodyType"));
					List<WebElement> BodyTypeOptions = drpdwnBodyType.findElements(By.tagName("option"));
					for (WebElement option : BodyTypeOptions ) {
						if(option.getText().contains(sBodyType))
							option.click();
					}
					Thread.sleep(2000);
					// Selecting State from Drop Down
					WebElement drpdwnState = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlState"));
					List<WebElement> stateOptions = drpdwnState.findElements(By.tagName("option"));
					for (WebElement option : stateOptions ) {
						if(option.getText().contains(sState))
							option.click();
					}
					Thread.sleep(2000);
					// Selecting Region from Drop Down
					WebElement drpdwnRegion = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlRegion"));
					List<WebElement> egionOptions = drpdwnRegion.findElements(By.tagName("option"));
					for (WebElement option : egionOptions ) {
						if(option.getText().contains(sRegion))
							option.click();
					}
					Thread.sleep(2000);
					// Selecting MinPrice from Drop Down
					WebElement drpdwnMinPrice = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceFrom"));
					List<WebElement> MinPriceOptions = drpdwnMinPrice.findElements(By.tagName("option"));
					for (WebElement option : MinPriceOptions ) {
						if(option.getText().contains(sPriceMin))
							option.click();
					}
					Thread.sleep(2000);
					// Selecting MaxPrice from Drop Down
					WebElement drpdwnMaxPrice = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlPriceTo"));
					List<WebElement> MaxPriceOptions = drpdwnMaxPrice.findElements(By.tagName("option"));
					for (WebElement option : MaxPriceOptions ) {
						if(option.getText().contains(sPriceMax))
							option.click();
					}
					Thread.sleep(2000);
					// Submit the form 
					driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_btnSubmit")).click();
					Thread.sleep(5000);
					// Selecting Last Updated from SortBy Drop Down
					driver.findElement(By.id("csn-select-ctl09_p_ctl02_ctl04_sortControl")).click();
					driver.findElement(By.linkText(sSortBy)).click();				
					Thread.sleep(3000);
					// Total Cars for Sale
					String sTotCars = driver.findElement(By.xpath("//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[1]/h1/span")).getText();
					System.out.println("Total cars for Sale :" + sTotCars);
					// List of Cars and Price Details		
					String s1 = "//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[";
					String s2 = "]/h2/a";
					String sp1 = "//html/body/form/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[";
					String sp2 = "]/div/div[2]/div[1]/p/a";
					// Car1 Details
					String sCarDetails1 = driver.findElement(By.xpath(s1+1+s2)).getText();
					System.out.println("Car Details :" + sCarDetails1);	
					xData[i][11] = sCarDetails1;
					String sCarPrice1 = driver.findElement(By.xpath(sp1+1+sp2)).getText();
					System.out.println("Car Price Details :" + sCarPrice1);
					xData[i][12] = sCarPrice1;
					// Car2 Details
					String sCarDetails2 = driver.findElement(By.xpath(s1+2+s2)).getText();
					System.out.println("Car Details :" + sCarDetails2);	
					xData[i][13] = sCarDetails1;
					String sCarPrice2 = driver.findElement(By.xpath(sp1+1+sp2)).getText();
					System.out.println("Car Price Details :" + sCarPrice1);
					xData[i][14] = sCarPrice2;
					// Car3 Details
					String sCarDetails3 = driver.findElement(By.xpath(s1+3+s2)).getText();
					System.out.println("Car Details :" + sCarDetails3);	
					xData[i][15] = sCarDetails3;
					String sCarPrice3 = driver.findElement(By.xpath(sp1+1+sp2)).getText();
					System.out.println("Car Price Details :" + sCarPrice1);
					xData[i][16] = sCarPrice3;
					// Car4 Details
					String sCarDetails4 = driver.findElement(By.xpath(s1+4+s2)).getText();
					System.out.println("Car Details :" + sCarDetails4);	
					xData[i][17] = sCarDetails1;
					String sCarPrice4 = driver.findElement(By.xpath(sp1+1+sp2)).getText();
					System.out.println("Car Price Details :" + sCarPrice4);
					xData[i][18] = sCarPrice1;
					// Car5 Details
					String sCarDetails5 = driver.findElement(By.xpath(s1+5+s2)).getText();
					System.out.println("Car Details :" + sCarDetails5);	
					xData[i][19] = sCarDetails1;
					String sCarPrice5 = driver.findElement(By.xpath(sp1+1+sp2)).getText();
					System.out.println("Car Price Details :" + sCarPrice5);
					xData[i][20] = sCarPrice1;
					
					} catch (Exception e){
					String sErrorMessage = e.getMessage();
					sReult = "Fail";
					sError = sErrorMessage;
					
				}
			} else {
				System.out.println("TestCase Execute mode is No!!!!");
			}
			
			xData[i][9] = sReult;
			xData[i][10] = sError;
		}
	}
	
	@After
	public void shutdown() throws Exception{
		xlwrite(xlRes_Path,xData);
		driver.quit();
	}
	
	public void xlRead(String sPath) throws Exception{
		File myxl = new File(sPath);
		FileInputStream myStream = new FileInputStream(myxl);
		
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		//HSSFSheet mySheet = new HSSFSheet(myWB);
		//HSSFSheet mySheet = myWB.getSheetAt(2);	// Referring to 3rd sheet
		HSSFSheet mySheet = myWB.getSheetAt(0);	// Referring to 1st sheet
		//int xRows = mySheet.getLastRowNum()+1;
		//int xCols = mySheet.getRow(0).getLastCellNum();
		xRows = mySheet.getLastRowNum()+1;
		xCols = mySheet.getRow(0).getLastCellNum();
		System.out.println("Rows are " + xRows);
		System.out.println("Cols are " + xCols);
		//String[][] xData = new String[xRows][xCols];
		xData = new String[xRows][xCols];
        for (int i = 0; i < xRows; i++) {
	           HSSFRow row = mySheet.getRow(i);
	            for (int j = 0; j < xCols; j++) {
	               HSSFCell cell = row.getCell(j); // To read value from each col in each row
	               String value = cellToString(cell);
	               xData[i][j] = value;
	               //System.out.print(value);
	               //System.out.print("@@");
	               }
	            //System.out.println("");	            
	        }			
	}
	
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
	                result = "-";
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
	public void xlwrite(String xlPath, String[][] xldata) throws Exception {
		System.out.println("Inside XL Write");
    	File outFile = new File(xlPath);
        HSSFWorkbook wb = new HSSFWorkbook();
           // Make a worksheet in the XL document created
        /*HSSFSheet osheet = wb.setSheetName(1,"TEST");*/
        HSSFSheet osheet = wb.createSheet("TESTRESULTS");
        // Create row at index zero ( Top Row)
    	for (int myrow = 0; myrow < xRows; myrow++) {
    		//System.out.println("Inside XL Write");
	        HSSFRow row = osheet.createRow(myrow);
	        // Create a cell at index zero ( Top Left)
	        for (int mycol = 0; mycol < xCols; mycol++) {
	        	HSSFCell cell = row.createCell(mycol);
	        	// Lets make the cell a string type
	        	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	        	// Type some content
	        	cell.setCellValue(xldata[myrow][mycol]);
	        	//System.out.print("..." + xldata[myrow][mycol]);
	        }
	        //System.out.println("..................");
	        // The Output file is where the xls will be created
	        FileOutputStream fOut = new FileOutputStream(outFile);
	        // Write the XL sheet
	        wb.write(fOut);
	        fOut.flush();
	        fOut.close();
    	}
    }
	
	
}
