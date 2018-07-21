package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import core.DriverFactory;

public class MenuPage extends BasePage {
  public void acessarFormulario() {
    clicarPorTexto("Formulário");
  }
  
  public void acessarSplash() {
    clicarPorTexto("Splash");
  }
  
  public void acessarAlertas() {
    clicarPorTexto("Alertas");
    esperar(1000);
  }
  
  public void acessarAbas() {
    clicarPorTexto("Abas");
  }
  
  public void acessarAccordion() {
    clicarPorTexto("Accordion");
  }
  
  public void acessarCliques() {
    clicarPorTexto("Cliques");
  }
  
  public void acessarSwipe() {
    clicarPorTexto("Swipe");
  }
  
  public void acessarSwipeList() {
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
    clicarPorTexto("Swipe List");
  }
  
  public void acessarDragNDrop() {
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
    clicarPorTexto("Drag and drop");
    esperar(1000);
  }
  
  public void acessarSBHibrido() {
    clicarPorTexto("SeuBarriga Híbrido");
  }
  
  public void acessarSBNativo() {
    clicarPorTexto("SeuBarriga Nativo");
  }
}
