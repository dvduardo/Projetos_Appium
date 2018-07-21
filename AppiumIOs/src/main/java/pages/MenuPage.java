package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import core.DriverFactory;

public class MenuPage extends BasePage {
  public void acessarContatos() {
    clicarPorTexto("Contatos");
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
    wait.until(ExpectedConditions
        .presenceOfElementLocated(By.xpath("//*[@text and @class='UIAView' and ./parent::*[@accessibilityLabel='Contatos']]")));
  }
}
