package teste;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import page.MenuPage;
import page.SplashPage;

public class SplashTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private SplashPage page = new SplashPage();
  
  @Test
  public void deveAguardarSplash() {
    menu.acessarSplash();
    page.isTelaSplashVisivel();
    page.aguardarSumir();
    Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
  }
}
