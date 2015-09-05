package practicesExcelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class Practice1 {
		WebDriver driver;
		String sUrl,sTitle,	sElement,sResult,sErrorMsg,sExecute;	
		String xData[][];
		int xRows, xCols;
		String xlPath = "D:\\EclipseProjects\\GuruBank\\Practice.xls";
		String xlPathRes = "D:\\EclipseProjects\\GuruBank\\Practice-Res.xls";
		String xlSheet = "Login";

	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Anu/Downloads/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		xData = readXL(xlPath, xlSheet);
		xRows = xData.length;
		xCols = xData[0].length;
	}
	@Test
	public void maintest() throws Exception{			
		for (int i = 1; i < xRows; i++) {
			sUrl = xData[i][0];
			sExecute = xData[i][5];
			sResult = "Pass";
			sErrorMsg = "No Error";
			if (sExecute.equalsIgnoreCase("y")) {			
				
				driver.get(sUrl);
				Thread.sleep(3000);
				String stitle = driver.getTitle();		
				String sURL = driver.getCurrentUrl();//sTitle,	sElement,sResult,sErrorMsg
				sTitle = xData[i][1];
				sElement = xData[i][2];
			}	
				/*xData[i][1] = sTitle;
				xData[i][2] = sElement;*/
			
				/*String sError = e.getMessage();
				sErrorMsg = sError;
				sResult = "Fail";	*/		
			
			sResult = xData[i][3];
			sErrorMsg = xData[i][4];
		}
	}
	
	@After
	public void shutdown() throws Exception{
	
		writeXL(xlPathRes,"Results",xData);
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
			xData[i][j] = value;   	//System.out.println(value);	//System.out.print("--");								
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
