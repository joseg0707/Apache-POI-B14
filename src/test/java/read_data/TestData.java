package read_data;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestData {

    File excelFile = new File("src/test/resources/TestData.xlsx");
    FileInputStream fileInputStream;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;

    @Before
    public void setUp() throws IOException {
        fileInputStream = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet1 = workbook.getSheet("Sheet1");
    }

    @Test
    public void getAllDataTest(){

        for (int i = sheet1.getFirstRowNum(); i < sheet1.getLastRowNum(); i++) {
            XSSFRow tempRow = sheet1.getRow(i);
            for (int j = tempRow.getFirstCellNum(); j < tempRow.getLastCellNum() ; j++) {
                System.out.print (tempRow.getCell(j) + " | ");
            }
            System.out.println();
        }
    }

    @Test
    public void getBusinessType(){
        String columnType = "BusinessType";
        XSSFRow row1 = sheet1.getRow(0);
        int index = 0;
        for (int i = row1.getFirstCellNum(); i < row1.getLastCellNum(); i++) {
            XSSFCell tempCell = row1.getCell(i);
            if (tempCell.getStringCellValue().equalsIgnoreCase(columnType)){
                index = i;
            }
        }
        for (int i = sheet1.getFirstRowNum(); i < sheet1.getLastRowNum(); i++) {
            XSSFRow tempRow = sheet1.getRow(i);
            System.out.println(tempRow.getCell(index));
        }

    }
}