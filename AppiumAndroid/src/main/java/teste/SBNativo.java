package teste;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.BaseTest;
import page.MenuPage;
import page.SBNativoPage;

public class SBNativo extends BaseTest {
  private MenuPage menu = new MenuPage();
  private SBNativoPage page = new SBNativoPage();
  
  @Before
  public void setup() {
    menu.acessarSBNativo();
    page.setEmail("a@teste");
    page.setSenha("123");
    page.entrar();
  }
  
  @Test
  public void criandoNovaConta() {
    page.abaContas();
    page.setNomeConta("Conta Teste");
    page.salvarConta();
    Assert.assertTrue(page.existeElementoPorTexto("Conta adicionada com sucesso"));
    
  }
  
  @Test
  public void excluindoConta() {
    page.abaContas();
    page.cliqueLongo(By.xpath("//*[@text='Conta Test']"));
    page.excluirConta();
    Assert.assertTrue(page.existeElementoPorTexto("Conta excluída com sucesso"));
  }
}

