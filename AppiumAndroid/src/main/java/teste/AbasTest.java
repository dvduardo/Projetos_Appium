package teste;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import page.AbasPage;
import page.MenuPage;

public class AbasTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private AbasPage page = new AbasPage();
  
  @Test
  public void interagirComAbas() {
    menu.acessarAbas();
    
    Assert.assertTrue(page.isAba1());
    
    page.selecionarAba2();
    
    Assert.assertTrue(page.isAba2());
    
    page.voltar();
    page.voltar();
  }
  
}
