package screens.withlogin;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import screens.BaseScreen;

public final class DashboardScreen extends BaseScreen {

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Bell Button Notifications\" AND accessible == 1`]")
  @AndroidFindBy(accessibility = "Bell Button Notifications")
  private WebElement buttonBell;


  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uE80C Transfer\"`]")
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uE80C']")
  private WebElement buttonTransfer;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uE80B Pay Bills\"`]")
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uE80B']")
  private WebElement payBills;

  public DashboardScreen(AppiumDriver driver) {
    super(driver);
  }

  @Step("Check that 'Dashboard' screen is displayed")
  public boolean isDisplayed() {
    return isDisplayed(accountNumber);
  }


  @Step("Tap bell icon button")
  public NotificationsScreen toNotifications() {
    click(buttonBell);
    return new NotificationsScreen(driver);
  }

  @Step("Tap 'Transfer' on Dashboard")
  public void toTransfer() {
    click(buttonTransfer);
  }

}
