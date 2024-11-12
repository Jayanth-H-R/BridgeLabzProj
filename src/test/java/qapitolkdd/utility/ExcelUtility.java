package qapitolkdd.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    public ExcelUtility(){

    }
    public XSSFSheet readData(String filePath) throws IOException {
        /*FileInputStream fis=new FileInputStream("./src/test/resources/KDDBook.xlsx");
       Workbook workBook=WorkbookFactory.create(fis);
       Sheet sheet=workBook.getSheetAt(0);*/
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);

        return sheet;




    }

}
