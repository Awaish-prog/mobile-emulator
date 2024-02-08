import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import java.util.concurrent.TimeUnit;

import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import java.net.URL;

public class SetupTestsMobileApp {
    private static AppiumDriver driver;
    private static Wait<WebDriver> wait;

    public static AppiumDriver getAppDriver() throws MalformedURLException {
        if(driver == null){
            DesiredCapabilities openFabricAppCapabilities = new DesiredCapabilities();
            openFabricAppCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
//            openFabricAppCapabilities.setCapability("deviceName", "Android");
            openFabricAppCapabilities.setCapability("app", System.getProperty("user.dir") + "/app-debug.apk");
            openFabricAppCapabilities.setCapability("automationName", "UiAutomator2");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), openFabricAppCapabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Login\"]"))).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text=\"Continue with Email\"]"))).click();
            WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[ancestor::android.view.View[descendant::android.view.View[contains(@text, \"Email\")]]]")));
            emailInput.sendKeys("awaishkhan79@gmail.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text=\"Continue\"]"))).click();
            WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[ancestor::android.view.View[descendant::android.view.View[contains(@text, \"Password\")]]]")));
            passwordInput.sendKeys("OpenfabricTheCommunity@12");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text=\"Sign in\"]"))).click();
        }
        return driver;
    }
}
