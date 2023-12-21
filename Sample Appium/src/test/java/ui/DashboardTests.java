package ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class DashboardTests extends BaseTest {

  @BeforeMethod
  public void beforeMethod() {
    getFirstLaunchScreen().accept().logIn().closeAd().discardTouchId().discardBancassur();
  }

  @Test
  @Description("Verify that user can navigate to 'Notifications' screen with button on dashboard")
  public void toNotifications() {
    getDashboardScreen().toNotifications();
    Assert.assertTrue(getNotificationsScreen().isTitleDisplayed());
  }

  @Test
  @Description("Verify that user can navigate to 'Transfer' screen with button on dashboard")
  public void toTransfer() {
    getDashboardScreen().toTransfer();
    Assert.assertTrue(getTransferScreen().isTitleDisplayed());
  }
}
