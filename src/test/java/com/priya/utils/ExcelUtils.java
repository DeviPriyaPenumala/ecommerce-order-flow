package com.priya.utils;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;


public class ExcelUtils {

public static Object[][] getExcelData(String filePath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[totalRows - 1][totalCols];

        for (int i = 1; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }
}

