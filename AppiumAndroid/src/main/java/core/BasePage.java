package core;

import static core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage {
  public void escrever(By by, String texto) {
    getDriver().findElement(by).sendKeys(texto);
  }
  
  public String obterTexto(By by) {
    return getDriver().findElement(by).getText();
  }
  
  public void selecionarCombo(By by, String nome) {
    getDriver().findElement(by).click();
    clicarPorTexto(nome);
  }
  
  public void clicar(By by) {
    getDriver().findElement(by).click();
  }
  
  public void clicarPorMobileId(String texto) {
    clicar(MobileBy.AccessibilityId(texto));
  }
  
  public void clicarPorTexto(String texto) {
    clicar(By.xpath("//*[@text='" + texto + "']"));
  }
  
  public boolean isCheckMarcado(By by) {
    return getDriver().findElement(by).getAttribute("checked").equals("true");
  }
  
  public boolean existeElementoPorTexto(String texto) {
    List<MobileElement> elemento = getDriver().findElements(By.xpath("//*[@text = '" + texto + "']"));
    return elemento.size() > 0;
  }
  
  public void voltar() {
    getDriver().navigate().back();
  }
  
  public String obterTitulo() {
    return obterTexto(By.id("android:id/alertTitle"));
  }
  
  public String obterMensagem() {
    return obterTexto(By.id("android:id/message"));
  }
  
  public void clicar(int x, int y) {
    new TouchAction(getDriver()).tap(x, y).perform();
  }
  
  public void esperar(long n) {
    try {
      Thread.sleep(n);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public void cliqueLongo(By by) {
    MobileElement inicio = DriverFactory.getDriver().findElement(by);
    new TouchAction(DriverFactory.getDriver()).longPress(inicio).release().perform();
  }
  
  public void scroll(double inicio, double fim) {
    Dimension size = getDriver().manage().window().getSize();
    int x = size.width / 2;
    int start_y = (int) (size.height * inicio);
    int end_y = (int) (size.height * fim);
    new TouchAction(getDriver()).press(x, start_y).waitAction(Duration.ofMillis(500)).moveTo(x, end_y).release().perform();
  }
  
  public void swipe(double inicio, double fim) {
    Dimension size = getDriver().manage().window().getSize();
    int y = size.height / 2;
    int start_x = (int) (size.width * inicio);
    int end_x = (int) (size.width * fim);
    new TouchAction(getDriver()).press(start_x, y).waitAction(Duration.ofMillis(500)).moveTo(end_x, y).release().perform();
  }
  
  public void swipeElement(MobileElement elemento, double inicio, double fim) {
    int y = elemento.getLocation().y + (elemento.getSize().height / 2);
    int start_x = (int) (elemento.getSize().width * inicio);
    int end_x = (int) (elemento.getSize().width * fim);
    new TouchAction(getDriver()).press(start_x, y).waitAction(Duration.ofMillis(500)).moveTo(end_x, y).release().perform();
  }
}
