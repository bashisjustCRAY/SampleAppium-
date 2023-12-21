package gestures;

import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public final class Taps {

  public static void tapAtRelXRelY(AppiumDriver driver, double relX, double relY) {
    if ((relX > 1) || (relX < 0) || (relY > 1) || (relY < 0)) {
      throw new IllegalArgumentException("illegal relative coordinate");
    }
    Point target = new Point((int) (driver.manage().window().getSize().getWidth() * relX),
        (int) (driver.manage().window().getSize().getHeight() * relY));
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence tap = new Sequence(finger, 1);
    tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), target.x, target.y));
    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(
        finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), target.x,
            target.y));
    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(List.of(tap));
  }

  public static void tapElementAtRelXRelY(AppiumDriver driver, WebElement element, double relX,
      double relY) {
    if ((relX > 1) || (relX < 0) || (relY > 1) || (relY < 0)) {
      throw new IllegalArgumentException("illegal relative coordinate");
    }
    Point target = new Point((int) (element.getLocation().x + element.getSize().getWidth() * relX),
        (int) (element.getLocation().y + element.getSize().getHeight() * relY));
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence tap = new Sequence(finger, 1);
    tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), target.x, target.y));
    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(
        finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), target.x,
            target.y));
    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(List.of(tap));
  }


}
