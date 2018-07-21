package page;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {
  public void escreverNome(String nome) {
    escrever(MobileBy.AccessibilityId("nome"), nome);
  }
  
  public String obterNome() {
    return obterTexto(MobileBy.AccessibilityId("nome"));
  }
  
  public void selecionarCombo(String nome) {
    selecionarCombo(MobileBy.AccessibilityId("console"), nome);
  }
  
  public void clicarCheck() {
    clicar(By.className("android.widget.CheckBox"));
  }
  
  public void clicarSwitch() {
    clicar(By.className("android.widget.Switch"));
  }
  
  public boolean IsCheck() {
    return isCheckMarcado(By.className("android.widget.CheckBox"));
  }
  
  public boolean isSwitch() {
    return isCheckMarcado(By.className("android.widget.Switch"));
  }
  
  public void salvar() {
    clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));
  }
  
  public String obterNomeCadas() {
    return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
  }
  
  public String obterConsoleCadas() {
    return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
  }
  
  public String obterSwitchCadas() {
    return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
  }
  
  public String obterCheckCadas() {
    return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
  }
  
  public void clicarSeekBar(double position) {
    int delta = 50;
    MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
    int y = seek.getLocation().y + (seek.getSize().height / 2);
    System.out.println(y);
    
    int xInicial = seek.getLocation().x + delta;
    int x = (int) (xInicial + ((seek.getSize().width - 2*delta) * position));
    System.out.println(x);
    
    clicar(x, y);
  }
}
