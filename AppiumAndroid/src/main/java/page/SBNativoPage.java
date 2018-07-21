package page;

import org.openqa.selenium.By;

import core.BasePage;

public class SBNativoPage extends BasePage {
  public void setEmail(String email) {
    escrever(By.xpath(
        "(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]/*[@class='android.widget.EditText'])[1]"),
        email);
  }
  
  public void setSenha(String senha) {
    escrever(By.xpath(
        "(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]/*[@class='android.widget.EditText'])[2]"),
        senha);
  }
  
  public void entrar() {
    clicarPorTexto("ENTRAR");
  }
  
  public void abaContas() {
    clicarPorTexto("CONTAS");
  }
  
  public void setNomeConta(String nome) {
    escrever(By.xpath("//*[@class='android.widget.EditText' and @width>0]"), nome);
  }
  
  public void salvarConta() {
    clicarPorTexto("SALVAR");
  }
  
  public void excluirConta() {
    clicarPorTexto("EXCLUIR");
  }
}

