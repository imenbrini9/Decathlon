package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Helper.Utils;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDef {
	
	@Given("utilisateur est sur home page")
	public void utilisateur_est_sur_home_page() throws Exception {
		Config.driver = new ChromeDriver();
		Config.maximize();
		Config.driver.get(Utils.getProperty("homeDecathlon"));
		
	  
	}
	@When("utilisateur clique sur menu {string} puis sur le sous menu {string}")
	public void utilisateur_clique_sur_menu_puis_sur_le_sous_menu(String menuTitle, String submenuTitle) {
		HomePage page = new HomePage();
		page.clichOnMenu(menuTitle, submenuTitle);
	
	}
	@Then("utilisateur dirige vers la page produit {string}")
	public void utilisateur_dirige_vers_la_page_produit(String sub) {
		HomePage page = new HomePage();
		page.verifMenu(sub);
	   
	}

}
