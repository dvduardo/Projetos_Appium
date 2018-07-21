package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory {
  private static IOSDriver<MobileElement> driver;
  
  
  public static IOSDriver<MobileElement> getDriver() {
    if (driver == null) {
      createDriver();
    }
    return driver;
  }
  
  public static void createDriver() {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "IOS");
    //desiredCapabilities.setCapability("testobject_api_key", "40504655AAB340C5832B4A62D801D3C2");
    desiredCapabilities.setCapability("appiumVersion", "1.7.2");
    desiredCapabilities.setCapability("deviceName", "574ab909005916bc46f24ec1baaf322b059c8200");
    desiredCapabilities.setCapability("automationName", "uiautomator2");
    //desiredCapabilities.setCapability("appPackage", "com.ctappium");
   // desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
    try {
      driver = new IOSDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities);
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }
  
  public static void killDriver() {
    if (driver != null)
      driver.quit();
    driver = null;
  }
}
