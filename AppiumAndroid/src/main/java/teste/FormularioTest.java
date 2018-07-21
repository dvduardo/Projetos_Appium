package teste;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import io.appium.java_client.MobileBy;
import page.FormularioPage;
import page.MenuPage;

public class FormularioTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private FormularioPage form = new FormularioPage();
  
  @Before
  public void inicializarAppium() {
    menu.acessarFormulario();
  }
  
  @Test
  public void preencherFormulario() throws MalformedURLException, InterruptedException {
    form.escreverNome("David");
    form.selecionarCombo("PS4");
    form.clicarPorTexto("01/01/2000");
    form.clicar(MobileBy.AccessibilityId("Próximo mês"));
    form.clicarPorTexto("23");
    form.clicarPorTexto("OK");
    Assert.assertTrue(form.existeElementoPorTexto("23/3/2000"));
    Assert.assertFalse(form.IsCheck());
    Assert.assertTrue(form.isSwitch());
    form.clicarCheck();
    form.clicarSwitch();
    form.clicarPorTexto("06:00");
    form.clicarPorMobileId("12");
    form.clicarPorMobileId("30");
    form.clicarPorTexto("OK");
    form.salvar();
    Assert.assertEquals("Nome: David", form.obterNomeCadas());
    Assert.assertEquals("Console: ps4", form.obterConsoleCadas());
    Assert.assertTrue(form.obterSwitchCadas().endsWith("Off"));
    Assert.assertTrue(form.obterCheckCadas().endsWith("Marcado"));
    form.voltar();
  }
  
  @Test
  public void seekBar() {
    form.clicarSeekBar(0.55);
    form.salvar();
  }
}