package page;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class SwipePage extends BasePage {
  
  public void swipeEsquerda(String texto) {
    swipeElement(getDriver().findElement(By.xpath("//*[@text='"+texto+"']/..")), 0.9, 0.1);
  }
  
  public void swipeDireita(String texto) {
    swipeElement(getDriver().findElement(By.xpath("//*[@text='"+texto+"']/..")), 0.1, 0.9);
  }
  
  public void clicarBotaoMais() {
    MobileElement x = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
    new TouchAction(getDriver())
    .tap(x, -50, 0)
    .perform();
  }
}
