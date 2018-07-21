package teste;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import core.BaseTest;
import page.DragPage;
import page.MenuPage;

public class DragNDropTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private DragPage page = new DragPage();
  private String[] estadoInicial = new String[] { "Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para",
      "qualquer local desejado.", };
  private String[] estadoIntermediario = new String[] { "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta",
      "qualquer local desejado.", };
  private String[] estadoFinal = new String[] { "Fa�a um clique longo,", "� uma lista", "Drag em Drop!", "e arraste para", "Esta",
      "qualquer local desejado.", };
  
  @Test
  public void DragNDrop() {
    menu.scroll(0.9, 0.1);
    menu.acessarDragNDrop();
    assertArrayEquals(estadoInicial, page.obterLista());
    page.arrastar("Esta", "e arraste para");
    assertArrayEquals(estadoIntermediario, page.obterLista());
    page.arrastar("Fa�a um clique longo,", "� uma lista");
    assertArrayEquals(estadoFinal, page.obterLista());
  }
}
