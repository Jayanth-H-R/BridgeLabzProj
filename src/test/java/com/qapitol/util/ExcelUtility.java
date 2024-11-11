package com.qapitol.util;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    public ExcelUtility(){

    }
    @DataProvider
    public Object [][]readStringData () throws IOException {
        FileInputStream fis=new FileInputStream("./src/test/resources/Book.xlsx");
       Workbook workBook=WorkbookFactory.create(fis);
        Sheet sheet=workBook.getSheet("Sheet1");
        int rows=sheet.getPhysicalNumberOfRows();
        System.out.println(rows);
        int lastCell= sheet.getRow(0).getLastCellNum();
        System.out.println(lastCell);

        Object [][] obj=new Object[rows][lastCell];

        for(int i=1; i<rows;i++) {
            for (int j = 0; j < lastCell; j++) {
                CellType cellTyp = sheet.getRow(i).getCell(j).getCellType();
                //System.out.println(cellTyp);
                if (cellTyp != null) {
                    if (cellTyp.toString().equalsIgnoreCase("String")) {
                        obj[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                        System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                    } else if (cellTyp.toString().equalsIgnoreCase("NUMERIC")) {
                        obj[i - 1][j] = sheet.getRow(i).getCell(j).getNumericCellValue();
                        System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
                    }
                }
            }
        }
        return obj;
    }
}
