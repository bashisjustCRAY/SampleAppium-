package propertyprovider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;

public final class PropertyProvider {

  public static URL provideUrl(String url) {
    try {
      System.getProperties().load(ClassLoader.getSystemResourceAsStream("url.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    try {
      return new URL(System.getProperty(url));
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public static String provideApp(String app) {
    try {
      System.getProperties().load(ClassLoader.getSystemResourceAsStream("app.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return System.getProperty(app);
  }

  public static Platform providePlatform(String platform) {
    try {
      System.getProperties().load(ClassLoader.getSystemResourceAsStream("platform.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return Platform.valueOf(System.getProperty(platform).toUpperCase());
  }


  public static String provideUdid(String udid) {
    try {
      System.getProperties().load(ClassLoader.getSystemResourceAsStream("udid.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return System.getProperty(udid);
  }


}
