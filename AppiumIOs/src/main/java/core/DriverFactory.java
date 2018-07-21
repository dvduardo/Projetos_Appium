package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
  static DesiredCapabilities dc = new DesiredCapabilities();
  static protected IOSDriver<IOSElement> driver = null;
  
  public static IOSDriver<IOSElement> getDriver() {
    if (driver == null) {
      createDriver();
    }
    return driver;
  }
  
  public static void createDriver() {
    dc.setCapability("reportDirectory", "reports");
    dc.setCapability("reportFormat", "xml");
    dc.setCapability("testName", "teste");
    dc.setCapability(MobileCapabilityType.UDID, "574ab909005916bc46f24ec1baaf322b059c8200");
    try {
      driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    } catch (MalformedURLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    driver.setLogLevel(Level.INFO);
  }
  
  public static void killDriver() {
    if (driver != null)
      driver.quit();
    driver = null;
  }
}