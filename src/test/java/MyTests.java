import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.time.Duration;

public class MyTests {
    @Test
    public void testDashboardTest() throws MalformedURLException {
        AppiumDriver driver = SetupTestsMobileApp.getAppDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Earn GEMs by Contributing to Your Favorite AI Community\"]")));
    }

    @Test
    public void testDashboard2Test() throws MalformedURLException {
        AppiumDriver driver = SetupTestsMobileApp.getAppDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text=\"Join 130k+ people exploring AI every day with us\"]")));
    }
}
