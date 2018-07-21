package page;

import java.util.Set;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;

public class SBHibridoPage extends BasePage {
  
  public void entrarContexto() {
    esperar(2000);
    Set<String> contexto = DriverFactory.getDriver().getContextHandles();
    DriverFactory.getDriver().context((String) contexto.toArray()[1]);
  }
  
  public void setEmail(String email) {
    System.out.println("chegou");
    DriverFactory.getDriver().findElement(By.id("email")).sendKeys(email);
  }
}
