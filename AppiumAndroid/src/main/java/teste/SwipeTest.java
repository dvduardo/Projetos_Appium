package teste;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import page.MenuPage;

public class SwipeTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  
  
  @Test
  public void Swipe() {
    menu.acessarSwipe();

    Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
    
    menu.swipe(0.9, 0.1);
    
    Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
    
    menu.clicarPorTexto("�");
    
    Assert.assertTrue(menu.existeElementoPorTexto("Chegar at� o fim!"));
    
    menu.swipe(0.1, 0.9);
    
    menu.clicarPorTexto("�");
    
    Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

    
  }
}
