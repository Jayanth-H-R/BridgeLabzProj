package TestCase;

import com.myntra.pages.*;
import com.generic.utility.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class MyntraTestCases extends BaseClass {

    @BeforeMethod
    public void configBefore() throws IOException {
        setUp();
    }

    @Test
    public void loginTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage lPage = new LoginPage(driver);
        ProfilePage profile = new ProfilePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        Thread.sleep(3000);
        try {
            if (lPage.pushNotificationPopup.isDisplayed()) {
                lPage.pushNotificationPopup.click();
            }
            Thread.sleep(3000);
            // homePage.loginButton.click();
            lPage.myntraStoreBanner.click();
            wait.until(ExpectedConditions.elementToBeClickable(homePage.profileIcon)).click();
            wait.until(ExpectedConditions.elementToBeClickable(profile.loginButton)).click();
            profile.mobileNumberTextField.sendKeys(fileUtils.readData("mobile"));
            //wait.until(ExpectedConditions.elementToBeClickable(homePage.loginButton)).click();
            profile.continueButton.click();
            Thread.sleep(3000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        /*TouchAction action=new TouchAction<>((PerformsTouchActions) driver);
        action.tap(PointOption.point(1012,469)).perform();*/
        //homePage.categoryIcon.click();


    }

    @Test
    public void addingCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage lPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        Thread.sleep(3000);
        try {
            if (lPage.pushNotificationPopup.isDisplayed()) {
                lPage.pushNotificationPopup.click();
            }
            Thread.sleep(3000);
            // homePage.loginButton.click();
            lPage.myntraStoreBanner.click();
            //wait.until((ExpectedConditions.elementToBeClickable(homePage.menTshirts))).click();
            homePage.menTshirts.click();
            MenTshirtsPage tshirtsPage = new MenTshirtsPage(driver);
            tshirtsPage.roundNeckT.click();
            //tshirtsPage.searchIcon.click();
            //wait.until(ExpectedConditions.elementToBeClickable(tshirtsPage.searchFeild)).click();
            tshirtsPage.mastAndHarbourTee.click();
            ProductPage productPage = new ProductPage(driver);
            productPage.addToBag.click();
            productPage.mSizeTee.click();
            //wait.until(ExpectedConditions.elementToBeClickable(productPage.sizeSelectionDone)).click();
            Thread.sleep(3000);
            productPage.sizeSelectionDone.click();
            wait.until(ExpectedConditions.elementToBeClickable(productPage.bagIcon)).click();
            Boolean result = wait.until(ExpectedConditions.attributeToBe(productPage.itemsList, "text", "1/1 ITEMS SELECTED"));
            Assert.assertTrue(result, "Item not added");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void configAfter() {

        tearDown();
    }
}
