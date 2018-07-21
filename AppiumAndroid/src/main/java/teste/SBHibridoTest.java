package teste;

import org.junit.Test;

import core.BaseTest;
import page.MenuPage;
import page.SBHibridoPage;

public class SBHibridoTest extends BaseTest {
  private MenuPage menu = new MenuPage();
  private SBHibridoPage page = new SBHibridoPage();
  
  @Test
  public void interagindoComWeb() {
   
    menu.acessarSBHibrido();
    
   // page.entrarContexto();
    page.setEmail("abc@edt");
    
    
  }
}
