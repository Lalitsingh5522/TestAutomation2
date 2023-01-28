package qtriptest;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP {

	//static data

	@DataProvider(name="fetchDataTC1")
    public static Object[][] getUserDataForTC1() throws IOException{
		return excelDP1();
    }

	@DataProvider(name="fetchDataTC2")
    public static Object[][] getUserDataForTC2() throws IOException{
		return excelDP2();
    }

	@DataProvider(name="fetchDataTC3")
    public static Object[][] getUserDataForTC3() throws IOException{
		return excelDP3();
    }

	@DataProvider(name="fetchDataTC4")
    public static Object[][] getUserDataForTC4() throws IOException{
		return excelDP4();
    }


  
  	public static Object[][] excelDP1() throws IOException{
        	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        	Object[][] arrObj = getExcelData("/home/crio-user/workspace/lalitsingh5522-ME_QTRIP_QA/lalitsingh5522-ME_QTRIP_QA/app/src/test/resources/DatasetsforQTrip.xlsx","TestCase01");
        	return arrObj;
  	}

  	public static Object[][] excelDP2() throws IOException{
        	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        	Object[][] arrObj = getExcelData("/home/crio-user/workspace/lalitsingh5522-ME_QTRIP_QA/lalitsingh5522-ME_QTRIP_QA/app/src/test/resources/DatasetsforQTrip.xlsx","TestCase02");
        	return arrObj;
  	}

  	public static Object[][] excelDP3() throws IOException{
        	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        	Object[][] arrObj = getExcelData("/home/crio-user/workspace/lalitsingh5522-ME_QTRIP_QA/lalitsingh5522-ME_QTRIP_QA/app/src/test/resources/DatasetsforQTrip.xlsx","TestCase03");
        	return arrObj;
  	}

  	public static Object[][] excelDP4() throws IOException{
        	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        	Object[][] arrObj = getExcelData("/home/crio-user/workspace/lalitsingh5522-ME_QTRIP_QA/lalitsingh5522-ME_QTRIP_QA/app/src/test/resources/DatasetsforQTrip.xlsx","TestCase04");
        	return arrObj;
  	}


  	//This method handles the excel - opens it and reads the data from the respective cells using a for-loop & returns it in the form of a string array
  	public static String[][] getExcelData(String fileName, String sheetName){
        	
        	String[][] data = null;   	
  	  	try
  	  	{
  	   	FileInputStream fis = new FileInputStream(fileName);
  	   	XSSFWorkbook wb = new XSSFWorkbook(fis);
  	   	XSSFSheet sh = wb.getSheet(sheetName);
  	   	XSSFRow row = sh.getRow(0);
  	   	int noOfRows = sh.getPhysicalNumberOfRows();
  	   	int noOfCols = row.getLastCellNum();
  	   	XSSFCell cell;
  	   	data = new String[noOfRows-1][noOfCols-1];
	
		
  	   	for(int i =1; i<noOfRows;i++){
  		     for(int j=1;j<noOfCols;j++){
  		    	   row = sh.getRow(i);
  		    	   cell= row.getCell(j);
					 DataFormatter formatter = new DataFormatter();
					
  		    	   data[i-1][j-1] = formatter.formatCellValue(cell);
				//    System.out.println(data[i-1][j-1]);
  	   	 	   }
  	   	}
  	  	}
  	  	catch (Exception e) {
  	     	   System.out.println("The exception is: " +e.getMessage());
  	     	           	}
        	return data;
  	}
	
}
