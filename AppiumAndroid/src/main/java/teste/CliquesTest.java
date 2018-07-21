package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.BaseTest;
import page.CliquesPage;
import page.MenuPage;

public class CliquesTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private CliquesPage page = new CliquesPage();
  
  @Before
  public void setup() {
    menu.acessarCliques();
  }
  
  @Test
  public void clicarLongo() {
    page.cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
    Assert.assertEquals("Clique Longo", page.obterTextoClique());
  }
  
  @Test
  public void cliqueDuplo() {
    page.clicarPorTexto("Clique duplo");
    page.clicarPorTexto("Clique duplo");
    Assert.assertEquals("Duplo Clique", page.obterTextoClique());
    
    
  }
}
