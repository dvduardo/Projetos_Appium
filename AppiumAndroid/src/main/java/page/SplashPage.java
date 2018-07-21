package page;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class SplashPage extends BasePage {
  public boolean isTelaSplashVisivel() {
    return existeElementoPorTexto("Splash!");
  }
  
  public void aguardarSumir() {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text ='Splash!']")));
  }
}
