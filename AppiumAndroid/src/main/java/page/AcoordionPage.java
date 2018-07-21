package page;

import org.openqa.selenium.By;

import core.BasePage;

public class AcoordionPage extends BasePage {
  /**
   * 
   * @param numero 
   */
  public void clicarOpcao(String numero) {
    clicarPorTexto("Opção " + numero + "");
    esperar(2000);
  }
  
  public String retornaOp1() {
    return obterTexto(By.xpath("//*[@text = 'Esta é a descrição da opção 1']"));
  }
}
