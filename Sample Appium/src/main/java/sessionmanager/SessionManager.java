package sessionmanager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.URL;
import java.time.Duration;
import propertyprovider.PropertyProvider;

public final class SessionManager {

  private static final URL GRID_URL = PropertyProvider.provideUrl("url");

  public static AndroidDriver androidSetup() {
    UiAutomator2Options options = new UiAutomator2Options()
        .setFullReset(false)
        .setNoReset(false)
        .setAutoGrantPermissions(true)
        .clearDeviceLogsOnStart()
        .setLanguage("en")
        .setLocale("NG")
        .setLogcatFormat("brief")
        .disableWindowAnimation()
        .setNewCommandTimeout(Duration.ofSeconds(300))
        .setUdid(PropertyProvider.provideUdid("androidUdid"))
        .setApp(PropertyProvider.provideApp("androidApp"))
        .setAppPackage("com.app.app")
        .setAppActivity(".SplashActivity");
    return new AndroidDriver(GRID_URL, options);
  }

  public static IOSDriver iosSetup() {
    XCUITestOptions options =
        new XCUITestOptions()
            .setFullReset(false)
            .setNoReset(false)
            .setAutoAcceptAlerts(true)
            .setLanguage("en")
            .setNewCommandTimeout(Duration.ofSeconds(300))
            .setUdid(PropertyProvider.provideUdid("iosUdid"))
            .setApp(PropertyProvider.provideApp("iosApp"));
    return new IOSDriver(GRID_URL, options);
  }
}
