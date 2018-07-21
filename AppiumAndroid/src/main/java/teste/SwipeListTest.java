package teste;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import page.MenuPage;
import page.SwipePage;

public class SwipeListTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private SwipePage page = new SwipePage();
  
  @Test
  public void rodandoSwipeList() {
    menu.scroll(0.9, 0.1);
    menu.acessarSwipeList();
    page.swipeEsquerda("Opção 1");
    page.clicarBotaoMais();
    Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
    page.swipeEsquerda("Opção 4");
    page.clicarPorTexto("(-)");
    Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));
    page.swipeDireita("Opção 5 (-)");
    Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));
  }
}
