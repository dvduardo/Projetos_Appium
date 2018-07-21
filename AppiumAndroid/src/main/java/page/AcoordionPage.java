package page;

import org.openqa.selenium.By;

import core.BasePage;

public class AcoordionPage extends BasePage {
  /**
   * 
   * @param numero 
   */
  public void clicarOpcao(String numero) {
    clicarPorTexto("Op��o " + numero + "");
    esperar(2000);
  }
  
  public String retornaOp1() {
    return obterTexto(By.xpath("//*[@text = 'Esta � a descri��o da op��o 1']"));
  }
}
