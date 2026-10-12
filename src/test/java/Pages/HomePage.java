package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class HomePage {
	
	@FindBy(xpath="/html/body/os-header/header/section/nav/ul/li/button")
	List<WebElement> menus;
	
	@FindBy(xpath="/html/body/os-header/header/section/nav/ul/li[4]/div/div[2]/nav/ul/li[2]/ul/li/a")
	List<WebElement> subMenus;
	
	@FindBy(xpath="/html/body/main/div[1]/div/h1/span")
	WebElement verif;
	@FindBy(id="didomi-notice-agree-button")
	WebElement accept;
	
	public HomePage() {
		PageFactory.initElements(Config.driver, this);
	}
	
	public void clichOnMenu(String menuTitle,String submenuTitle) {
		Config.attente(6);
		accept.click();
		try {
			for(WebElement menu:menus) {
				if(menu.getText().contains(menuTitle)) {
				menu.click();
				for(WebElement submenu:subMenus) {
					if(submenu.getText().contains(submenuTitle)) {
						submenu.click();
					}
				}
				}
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void verifMenu (String submenuT) {
		Assert.assertEquals(verif.getText(), submenuT);
	}
	

}
