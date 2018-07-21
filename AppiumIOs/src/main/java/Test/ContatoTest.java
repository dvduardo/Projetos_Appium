package Test;

import org.junit.Test;

import core.BaseTest;
import pages.ContatosPage;
import pages.MenuPage;

public class ContatoTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private ContatosPage page = new ContatosPage();
  
  @Test
  public void criarContato() {
    page.criarNovo();
    page.preencherContato("ContatoTeste", "34992033617", "Everis Uberlandia");
    page.clicarOk();
    page.voltarContatos();
  }
  
  @Test
  public void excluirContato() {
    page.pesquisarCliente("ContatoTeste");
    page.clicarEditar();
    menu.scroll(0.9, 0.1);
    menu.scroll(0.9, 0.1);
    page.apagarContato();
  }
}
