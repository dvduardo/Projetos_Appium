package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import page.AlertaPage;
import page.MenuPage;

public class AlertTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private AlertaPage page = new AlertaPage();
  
  @Before
  public void setup() {
    menu.acessarAlertas();
  }
  
  @Test
  public void alertaConfirmar() {
    page.clicarAlertaConfirm();
    Assert.assertEquals("Info", page.obterTitulo());
    Assert.assertEquals("Confirma a operação?", page.obterMensagem());
    page.confirma();
    Assert.assertEquals("Confirmado", page.obterMensagem());
    page.sair();
  }
  
  @Test
  public void alertaSimples() {
    page.clicarAlertaSimples();
    page.tap();
  }
}
