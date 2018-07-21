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
    page.swipeEsquerda("Op��o 1");
    page.clicarBotaoMais();
    Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));
    page.swipeEsquerda("Op��o 4");
    page.clicarPorTexto("(-)");
    Assert.assertTrue(page.existeElementoPorTexto("Op��o 4 (-)"));
    page.swipeDireita("Op��o 5 (-)");
    Assert.assertTrue(page.existeElementoPorTexto("Op��o 5"));
  }
}
