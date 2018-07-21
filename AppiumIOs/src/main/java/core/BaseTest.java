package core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.MenuPage;

public class BaseTest {
  private MenuPage menu = new MenuPage();
  
  @Before
  public void setup() {
    menu.acessarContatos();
  }
  
  @Rule
  public TestName testName = new TestName();
  
  @AfterClass
  public static void finalizaClasse() {
    DriverFactory.killDriver();
  }
  
  @After
  public void tearDown() {
    gerarScreenShot();
    DriverFactory.getDriver().resetApp();
    // DriverFactory.killDriver();
  }
  
  public void gerarScreenShot() {
    try {
      File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(imagem, new File("target/screenshots/" + testName.getMethodName() + ".png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
