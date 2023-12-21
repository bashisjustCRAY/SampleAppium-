package screens;

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public abstract class BaseScreen {

  final Logger log = getLogger(lookup().lookupClass());
  protected final AppiumDriver driver;
  private final WebDriverWait wait;
  private final int timeoutSec = Constants.SCREEN_TIMEOUT_SEC;

  public BaseScreen(AppiumDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
  }

  protected void click(WebElement element) {
    find(element).click();
  }

  protected WebElement find(WebElement element) {
    if (isDisplayed(element)) {
      return element;
    } else {
      throw new NoSuchElementException("element not found:" + element);
    }
  }

  protected boolean isDisplayed(WebElement element) {
    try {
      wait.until(ExpectedConditions.visibilityOf(element));
    } catch (TimeoutException e) {
      log.warn("Timeout of {} wait for {}", timeoutSec, element);
      return false;
    } catch (StaleElementReferenceException e) {
      wait.until(ExpectedConditions.visibilityOf(element));
      return true;
    }
    return true;
  }

}
