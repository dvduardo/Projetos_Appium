package core;

import static core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage {
  /**
   * @param by
   *          tipo de caminho para encontrar o campo a qual se deseja digitar algo
   * @param texto
   *          qual texto que deve ser escrito no campo selecionado
   */
  public void escrever(By by, String texto) {
    getDriver().findElement(by).sendKeys(texto);
  }
  
  /**
   * @param by
   *          tipo de caminho para encontrar o local pra o clique(recomendado o
   *          uso de xpath)
   */
  public void clicar(By by) {
    getDriver().findElement(by).click();
  }
  
  /**
   * @param texto
   *          texto de referencia para que ocorra o clique
   */
  public void clicarPorTexto(String texto) {
    clicar(By.xpath("//*[@text='" + texto + "']"));
  }
  
  /**
   * @param x:
   *          Ponto no eixo X para o clique ocorrer
   * @param y:
   *          Ponto no eixo Y para o clique ocorrer
   */
  public void clicar(int x, int y) {
    new TouchAction(getDriver()).tap(x, y).perform();
  }
  
  /**
   * @param n
   *          : Tempo de espera em milissegundos (1 segundo = 1000 milissegundos)
   */
  public void esperar(long n) {
    try {
      Thread.sleep(n);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * @param by
   *          : Tipo de caminho para encontrar o local para o clique
   *          longo(recomendado usar xpath)
   */
  public void cliqueLongo(By by) {
    MobileElement inicio = DriverFactory.getDriver().findElement(by);
    new TouchAction(DriverFactory.getDriver()).longPress(inicio).release().perform();
  }
  
  /**
   * @param inicio
   *          : lugar onde vai ser dado o tap inicial para scrollar
   * @param fim
   *          : lugar para onde ele vai arrastar vindo do estado inicio
   */
  public void scroll(double inicio, double fim) {
    Dimension size = getDriver().manage().window().getSize();
    int x = size.width / 2;
    int start_y = (int) (size.height * inicio);
    int end_y = (int) (size.height * fim);
    new TouchAction(getDriver()).press(x, start_y).waitAction(Duration.ofMillis(500)).moveTo(x, end_y).release().perform();
  }
  
  /**
   * @param inicio
   *          :Local de inicio para o swipe.
   * @param fim
   *          :local até onde o swipe vai chegar.
   */
  public void swipe(double inicio, double fim) {
    Dimension size = getDriver().manage().window().getSize();
    int y = size.height / 2;
    int start_x = (int) (size.width * inicio);
    int end_x = (int) (size.width * fim);
    new TouchAction(getDriver()).press(start_x, y).waitAction(Duration.ofMillis(500)).moveTo(end_x, y).release().perform();
  }
  
  /**
   * @param elemento
   *          Elemento de referencia para ocorrer o swipe
   * @param inicio
   *          local de inicio para o swipe
   * @param final
   *          até onde o movimento de swipe vai em relação ao elemento de
   *          referência.
   */
  public void swipeElement(MobileElement elemento, double inicio, double fim) {
    int y = elemento.getLocation().y + (elemento.getSize().height / 2);
    int start_x = (int) (elemento.getSize().width * inicio);
    int end_x = (int) (elemento.getSize().width * fim);
    new TouchAction(getDriver()).press(start_x, y).waitAction(Duration.ofMillis(500)).moveTo(end_x, y).release().perform();
  }
}
