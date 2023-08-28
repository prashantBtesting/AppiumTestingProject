import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestDemo {
    @Test
    public void AppiumTest() throws MalformedURLException {
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ThinkMad\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
        .withIPAddress("127.0.0.1").usingPort(4723).build(); // add appium server to start to avoid starting everytime it manually

        service.start(); // start service
        UiAutomator2Options options = new UiAutomator2Options(); // invoke browser on simulator
        options.setDeviceName("Pixel 2 XL API 34");
        options.setApp("E:\\AppiumProject\\src\\main\\resources\\ApiDemos-debug.apk");
        AndroidDriver  driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        //Actual Automation
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        driver.quit();

        service.stop();// Stoping service

    }

}
