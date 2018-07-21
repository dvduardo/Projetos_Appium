package page;

import core.BasePage;

public class AlertaPage extends BasePage {
  public void clicarAlertaConfirm() {
    clicarPorTexto("ALERTA CONFIRM");
  }
  
  public void clicarAlertaSimples() {
    clicarPorTexto("ALERTA SIMPLES");
    esperar(2000);
  }
  
  public void confirma() {
    clicarPorTexto("CONFIRMAR");
  }
  
  public void sair() {
    clicarPorTexto("SAIR");
  }
  
  public void tap() {
    clicar(494, 1492);
  }
}
