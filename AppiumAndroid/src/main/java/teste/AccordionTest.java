package teste;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import page.AcoordionPage;
import page.MenuPage;

public class AccordionTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private AcoordionPage page = new AcoordionPage();
  
  @Test
  public void InteragirAcoordion() {
    menu.acessarAccordion();
    page.clicarOpcao("1");
    Assert.assertEquals("Esta é a descrição da opção 1", page.retornaOp1());
    page.clicarOpcao("1");
    page.clicarOpcao("2");
    page.voltar();
  }
}
