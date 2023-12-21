package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import propertyprovider.PropertyProvider;
import screens.withlogin.DashboardScreen;
import sessionmanager.SessionManager;

@Owner("B. Alatishe")
public abstract class BaseTest {

  private final Platform platform = PropertyProvider.providePlatform("platform");
  private final ThreadLocal<AndroidDriver> threadLocalAndroidDriver = new ThreadLocal<>();
  private final ThreadLocal<IOSDriver> threadLocalIOSDriver = new ThreadLocal<>();

  @BeforeMethod
  protected void setup() {
    if (platform == Platform.ANDROID) {
      threadLocalAndroidDriver.set(SessionManager.androidSetup());
    } else if (platform == Platform.IOS) {
      threadLocalIOSDriver.set(SessionManager.iosSetup());
    } else {
      throw new IllegalArgumentException("platform " + platform);
    }
    //((SupportsLocation) getDriver()).setLocation(Location);
  }

  @AfterMethod
  protected void teardown() {
    if (getDriver() != null) {
      Allure.addAttachment("mobile: deviceInfo",
          getDriver().executeScript("mobile: deviceInfo").toString());
      getDriver().quit();
      if (platform == Platform.ANDROID) {
        threadLocalAndroidDriver.remove();
      } else if (platform == Platform.IOS) {
        threadLocalIOSDriver.remove();
      }
    }
  }

  private AppiumDriver getDriver() {
    if (platform == Platform.ANDROID) {
      return threadLocalAndroidDriver.get();
    } else if (platform == Platform.IOS) {
      return threadLocalIOSDriver.get();
    } else {
      throw new IllegalArgumentException("platform " + platform);
    }
  }

  protected void addDeviceLogToAllure() {
    String logType = "";
    if (platform == Platform.ANDROID) {
      logType = "logcat";
    } else if (platform == Platform.IOS) {
      logType = "syslog";
    }
    LogEntries logEntries = getDriver().manage().logs().get(logType);
    StringBuilder logs = new StringBuilder();
    for (LogEntry entry : logEntries) {
      logs.append(entry.getLevel()).append(" ").append(entry.getMessage())
          .append(System.lineSeparator());
    }
    Allure.addAttachment(logType + " log:", logs.toString());
  }

  protected DashboardScreen getDashboardScreen() {
    return new DashboardScreen(getDriver());
  }
}
