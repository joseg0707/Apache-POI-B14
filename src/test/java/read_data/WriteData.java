package read_data;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class WriteData {

    File excelFile = new File("src/test/resources/TestSetup.xlsx");
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
    public void writeToFileTest() throws IOException {
        XSSFRow newRow = sheet1.createRow(sheet1.getLastRowNum()+1);
        XSSFCell newCell = newRow.createCell(0, CellType.STRING);
        newCell.setCellValue("Preprod");

        FileOutputStream fileOutputStream = new FileOutputStream(excelFile);
        workbook.write(fileOutputStream);


    }
}
