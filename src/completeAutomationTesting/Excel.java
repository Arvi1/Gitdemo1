package completeAutomationTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class Excel {
	int xRows, xCols;
	String xData[][];
	String xlPath, xlResultPath, xlSheet;
	String sUrl, sUsername, sPassword;
	
	@Test
	public void maintest() throws Exception{
		xlPath = "D:/EclipseProjects/CarPoint/Homepage.xls";
		xlResultPath = "D:\\EclipseProjects\\ToolsQA\\Homepage";//"D:/EclipseProjects/ToolsQA/Homepage.xls";//"D:/EclipseProjects/CarPoint/Homepage-Res.xls";
		xlSheet = "Test Cases";
		xData = readXL(xlPath, xlSheet);
		xRows = xData.length;
		xCols = xData[0].length;
		
		for (int i = 1; i < xRows; i++) {
		sUrl = xData[i][0];
		sUsername = xData[i][1];
		sPassword = xData[i][2];
		}
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
