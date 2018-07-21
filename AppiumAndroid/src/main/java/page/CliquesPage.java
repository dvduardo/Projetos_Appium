package page;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;

public class CliquesPage extends BasePage {
  public String obterTextoClique() {
    return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]")).getText();
    
  }
}
