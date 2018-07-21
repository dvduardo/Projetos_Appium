package teste;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTest;
import core.DriverFactory;
import page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  
  
  @Test
  public void opcaoEscondida() {
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
    menu.scroll(0.9, 0.1);
    menu.clicarPorTexto("Op��o bem escondida");
    Assert.assertEquals("Voc� achou essa op��o", menu.obterMensagem());
    menu.clicarPorTexto("OK");
  }
}
