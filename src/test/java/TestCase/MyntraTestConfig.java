package TestCase;

import com.generic.utility.BaseTest;
import com.myntra.pages.HomePage;
import com.myntra.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class MyntraTestConfig  extends BaseTest {

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        service = startServer();
        driver = capabilities("Myntra");
    }


    @SuppressWarnings("static-access")
    @Test
    public void screenShotTest() throws InterruptedException {

        try {

            System.out.println("Execution Started.... !!!");
            Thread.sleep(5000);
            HomePage homePage = new HomePage(driver);
            LoginPage lPage = new LoginPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            Thread.sleep(3000);
                Thread.sleep(1000);
                // homePage.loginButton.click();
                lPage.myntraStoreBanner.click();
                homePage.menTshirts.click();
            // Run the adb command to take a screenshot and save it to device's /sdcard/ directory
            Runtime.getRuntime().exec("adb shell screencap -p /sdcard/Pictures/Screenshot/myntra.png");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


//		WebElement first_textview = find_element(uiautomator, 'new UiSelector().className("android.widget.TextView").instance(0)');

    }
    @AfterSuite
    public void terminate() throws IOException {

        stopServer();
        stopEmulator();
    }


}
