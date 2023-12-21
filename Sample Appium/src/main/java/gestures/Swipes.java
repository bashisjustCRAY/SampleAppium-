package gestures;

import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;


public final class Swipes {

  public static void swipeAtRelXFromRelY1ToRelY2(AppiumDriver driver, double relX, double relY1,
      double relY2) {
    if ((relX > 1) || (relX < 0) || (relY1 > 1) || (relY1 < 0) || (relY2 > 1) || (relY2 < 0)) {
      throw new IllegalArgumentException("illegal relative coordinate");
    }
    Point source = new Point((int) (driver.manage().window().getSize().getWidth() * relX),
        (int) (driver.manage().window().getSize().getHeight() * relY1));
    Point target = new Point(driver.manage().window().getSize().getWidth() / 2,
        (int) (driver.manage().window().getSize().getHeight() * relY2));
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), source.x, source.y));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
        PointerInput.Origin.viewport(), target.x, target.y));
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(List.of(swipe));
  }

  public static void swipeAtRelYFromRelX1ToRelX2(AppiumDriver driver, double relY, double relX1,
      double relX2) {
    if ((relY > 1) || (relY < 0) || (relX1 > 1) || (relX1 < 0) || (relX2 > 1) || (relX2 < 0)) {
      throw new IllegalArgumentException("illegal relative coordinate");
    }
    Point source = new Point((int) (driver.manage().window().getSize().getWidth() * relX1),
        (int) (driver.manage().window().getSize().getHeight() * relY));
    Point target = new Point((int) (driver.manage().window().getSize().getWidth() * relX2),
        (int) (driver.manage().window().getSize().getHeight() * relY));
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), source.x, source.y));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
        PointerInput.Origin.viewport(), target.x, target.y));
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(List.of(swipe));
  }

}
