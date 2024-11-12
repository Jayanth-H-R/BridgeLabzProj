package qapitolkdd.keyengine;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import qapitolkdd.utility.ExcelUtility;

import java.io.IOException;
import java.time.Duration;

public class KeyEngine {
    public  WebDriver driver;
    ExcelUtility utility = new ExcelUtility();

    public KeyEngine(WebDriver driver){
        this.driver=driver;
    }


    public void service(String path) throws IOException {

        XSSFSheet sheet = utility.readData(path);
        for (Row row : sheet) {
            String keyWord = row.getCell(0).getStringCellValue();
            String locatorType = row.getCell(1).getStringCellValue();
            String locatorValue = row.getCell(2).getStringCellValue();
            String data = row.getCell(3).getStringCellValue();

            switch (keyWord) {
                case "open browser":
                    if (data.equalsIgnoreCase("chrome")) {
                        driver = new ChromeDriver();
                    } else if (data.equalsIgnoreCase("edge")) {
                        driver = new EdgeDriver();

                    }
                    break;
                case "navigate":
                    driver.get(data);
                    driver.manage().window().maximize();
                    break;
                case "enter email":
                    getWebEle(locatorType,locatorValue).sendKeys(data);
                    break;
                case "enter password": getWebEle(locatorType,locatorValue).sendKeys(data);
                break;
                case "create button": getWebEle(locatorType, locatorValue).click();
                break;
                case "NA": break;
                default: System.out.println(" invalid keyword "+ keyWord);

            }
        }
    }

    public  WebElement getWebEle(String locatorType, String locatorValue){
        WebElement ele=null;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        switch (locatorType){
            case "id": ele= driver.findElement(By.id(locatorValue));
            break;
            case "class": ele=driver.findElement(By.className(locatorValue));
            break;
            case "name": ele=driver.findElement(By.name(locatorValue));
            break;
            case "xpath": ele=driver.findElement(By.xpath(locatorValue));
            break;
            case "cssselector": ele=driver.findElement(By.cssSelector(locatorValue));
            break;

            default: System.out.println("Invalid Selector" + locatorType);

        }
        return ele;
    }
    public void termination(){
        driver.manage().window().minimize();
        driver.quit();
    }
}

