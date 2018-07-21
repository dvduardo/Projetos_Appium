package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import core.DriverFactory;

public class ContatosPage extends BasePage {
  public void clicarOk() {
    clicar(By.xpath("(//*/*[@class='UIAButton'])[2]"));
  }
  
  public void criarNovo() {
    clicar(By.xpath("(//*/*[@class='UIAButton'])[2]"));
  }
  
  /**
   * @param nome
   *          nome do contato
   * @param phone
   *          telefone do contato
   * @param empresa
   *          empresa do contato
   */
  public void preencherContato(String nome, String phone, String empresa) {
    escrever(By.xpath("//*[@placeholder='Nome']"), nome);
    escrever(By.xpath("//*[@placeholder='Empresa']"), empresa);
    clicar(By.xpath("(//*[@class='UIATable']/*/*[@class='UIAButton' and ./parent::*[@text and @class='UIAView']])[1]"));
    scroll(0.5, 0.9);
    new WebDriverWait(DriverFactory.getDriver(), 2).until(ExpectedConditions
        .presenceOfElementLocated(By.xpath("((//*[@class='UIATable']/*[@class='UIAView'])[7]/*[@class='UIAButton'])[2]")));
    escrever(By.xpath("//*[@placeholder='Telefone']"), phone);
    esperar(2000);
    scroll(0.5, 0.9);
    scroll(0.9, 0.1);
    new WebDriverWait(DriverFactory.getDriver(), 2).until(ExpectedConditions.presenceOfElementLocated(By
        .xpath("//*[@class='UIAStaticText' and (./preceding-sibling::* | ./following-sibling::*)[@accessibilityLabel='NotesTextView']]")));
    clicar(By.xpath("//*[@accessibilityLabel='NotesTextView']"));
    esperar(1000);
    escrever(By.xpath("//*[@accessibilityLabel='NotesTextView']"), "Nota de teste");
    scroll(0.5, 0.9);
  }
  
  public void voltarContatos() {
    clicar(By.xpath("//*[@text='Contatos' and @class='UIAButton']"));
  }
  
  public void clicarEditar() {
    clicar(By.xpath("(//*/*[@class='UIAButton'])[2]"));
  }
  
  /**
   * @param cliente
   *          nome do cliente para fazer a pesquisa
   */
  public void pesquisarCliente(String cliente) {
    escrever(By.xpath(""), cliente);
    clicar(By.xpath(""));
  }
  
  public void apagarContato() {
    clicar(By.xpath(
        "(//*[@class='UIATable']/*/*[@class='UIAStaticText' and (./preceding-sibling::* | ./following-sibling::*)[@class='UIAView']])[17]"));
    clicar(By.xpath("(//*[@class='UIATable']/*[@class='UIAView' and @width>0 and @height>0])[34]"));
  }
}
