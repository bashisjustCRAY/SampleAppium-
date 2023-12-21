package screens.withoutlogin;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.BaseScreen;
import screens.withlogin.DashboardScreen;


public final class WelcomeScreen extends BaseScreen {


  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Bell Button Notifications\" AND accessible = 1`]")
  @AndroidFindBy(accessibility = "Bell Button Notifications")
  private WebElement buttonBell;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Login PIN\" AND accessible = 1`]")
  @AndroidFindBy(accessibility = "Login PIN")
  private WebElement mPINField;

  @iOSXCUITFindBy(accessibility = "Tile Button Quick Transfers")
  @AndroidFindBy(accessibility = "Tile Button Quick Transfers")
  private WebElement quickTransfers;
  @iOSXCUITFindBy(accessibility = "Tile Button Quick Airtime")
  @AndroidFindBy(accessibility = "Tile Button Quick Airtime")
  private WebElement quickAirtime;

  @iOSXCUITFindBy(accessibility = "Tile Button Quick QR")
  @AndroidFindBy(accessibility = "Tile Button Quick QR")
  private WebElement quickQR;

  public WelcomeScreen(AppiumDriver driver) {
    super(driver);
  }


  @Step("Enter valid mPIN")
  public WelcomeScreen logIn() {
    if (driver instanceof AndroidDriver) {
      click(mPINField);
      ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
      ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
      ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
      ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_9));
      ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));
    } else if (driver instanceof IOSDriver) {
      click(mPINField);
      click(driver.findElement(By.id("4")));
      click(driver.findElement(By.id("5")));
      click(driver.findElement(By.id("6")));
      click(driver.findElement(By.id("9")));
      click(driver.findElement(By.id("0")));
    }
    return this;
  }

  @Step("Tap 'Close ad'")
  public DashboardScreen closeAd() {
    click(buttonCloseAd);
    return new DashboardScreen(driver);
  }

  @Step("Check that welcome screen is displayed")
  public boolean isDisplayedWelcomeScreen() {
    return isDisplayed(mPINField);
  }

}
