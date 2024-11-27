package com.generic.utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

public class BaseTest {
    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;
    public static FileUtility fileUtility = new FileUtility();

    public static boolean checkIfServerIsRunning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();

        } catch (Exception e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static AppiumDriverLocalService startServer() {

        try {

            Runtime runtime = Runtime.getRuntime();
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(8000);
            System.out.println("Hold server creation");
            boolean flag = checkIfServerIsRunning(4723);

            if (!flag) {
                System.out.println("Server not started");
                service = AppiumDriverLocalService.buildDefaultService();
                service.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return service;
    }

    public static void stopServer() {

        System.out.println("Server stopped");
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
            Thread.sleep(3000);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void startEmulator() throws IOException{

        try {

            Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\ApkFiles\\Pixel 7a.bat");
            Thread.sleep(10000);
            System.out.println("Started Emulator");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopEmulator() throws IOException {
        try{
            String command = "adb -s emulator-5554 emu kill"; // emulator-5554  [emulator ID]
            Runtime.getRuntime().exec(command);
            System.out.println("Emulator killed successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static AndroidDriver capabilities(String appName) throws IOException, InterruptedException {
        String deviceSel = fileUtility.readData("device");

        try {
            if (deviceSel.contains("Emulator")) {
                startEmulator();
            }
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7a");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
            cap.setCapability("autoGrantPermissions", true);
            cap.setCapability(MobileCapabilityType.NO_RESET, false);
            cap.setCapability("appPackage", "com.myntra.android");
            cap.setCapability("appActivity", "com.myntra.android.activities.react.ReactActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }


}


