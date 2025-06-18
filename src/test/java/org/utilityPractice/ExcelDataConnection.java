package org.utilityPractice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataConnection {
    @DataProvider
    public static Object[][] connectWithExcel() throws IOException {
        String excelFilePath = "C://Users//krsk1//Downloads//MHI_NatureandIntendedPurpose_missing-updated_without special characters-1.xlsx";
        String sheet_name = "Duplicate";

        FileInputStream excelfile = new FileInputStream(excelFilePath);
        Workbook wb = new XSSFWorkbook(excelfile);
        Sheet sh = wb.getSheet(sheet_name);
        int rowCount = sh.getPhysicalNumberOfRows();
//        System.out.println("Row :: "+rowCount);
        int colCount = sh.getRow(0).getPhysicalNumberOfCells();
//        System.out.println("Col :: "+colCount);

        Object[][] cellVal = new Object[rowCount-1][2];
        for(int i=1; i < rowCount; i++){
            Row row = sh.getRow(i);
            if(row == null){
                cellVal[i-1][0] = "";
                cellVal[i-1][1] = "";
                continue;
            }

            Cell cell = row.getCell(4);
            String cell_val_first;
            if(cell != null) {
                cell_val_first = cell.getStringCellValue();
                cellVal[i-1][0] = cell_val_first;
            }
            else{
                cellVal[i-1][0] = "";
            }

            Cell cell1 = row.getCell(6);
            String cell_val_second;
            if(cell1 != null) {
                cell_val_second = cell1.getStringCellValue();
                cellVal[i-1][1] = cell_val_second;
            }
            else{
                cellVal[i-1][1] = "";
            }

//            if(cell_val_first != null && cell_val_second != null){
//                cellVal[i-1][0] = cell_val_first;
//                cellVal[i-1][1] = cell_val_second;
//            } else if (cell_val_first == null && cell_val_second != null) {
//                cellVal[i-1][0] = "";
//                cellVal[i-1][1] = cell_val_second;
//            }else if (cell_val_second == null && cell_val_first != null) {
//                cellVal[i-1][0] = cell_val_first;
//                cellVal[i-1][1] = "";
//            }

//            cellVal[i-1][0] = row.getCell(4).toString();
//            cellVal[i-1][1] = row.getCell(6).toString();
        }
        wb.close();
        return cellVal;

    }
}
