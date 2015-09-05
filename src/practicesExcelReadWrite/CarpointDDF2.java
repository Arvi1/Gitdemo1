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

public class CarpointDDF2 {

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
		driver.get("http://www.carpoint.com.au/");
		Thread.sleep(3000);
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
			if (sExecute.equals("Yes")) {
				try {
					WebElement drpdwnMake = driver.findElement(By.id("ctl07_p_d_ctl05_ctl01_ctl03_ctl01_ddlMake"));
					List<WebElement> makeOptions = drpdwnMake.findElements(By.tagName("option"));
					for (WebElement option : makeOptions ) {
						if(option.getText().contains(sMake))
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
					xData[i][11] = sTotCars;
					
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
