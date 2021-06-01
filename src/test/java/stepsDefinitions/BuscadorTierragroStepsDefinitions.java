package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Steps;
import pages.TierragroPage;
import steps.TierragroSteps;

public class BuscadorTierragroStepsDefinitions {

	@Steps
	TierragroSteps tierragroSteps = new TierragroSteps();
	
	
	@Given("^que me encuentro en la pagina de Tierragro$")
	public void queMeEncuentroEnLaPaginaDeTierragro() {
		
	   SeleniumWebDriver.chromeWebDriver("https://www.tierragro.com/");
	}


	@When("^busco el nombre del producto en el buscador$")
	public void buscoElNombreDelProductoEnElBuscador() {
		
		tierragroSteps.buscarPalabraEnTierragro("Sopladora STIHL BG 86");
	}

	@Then("^podre ver el producto$")
	public void podreVerElProducto() {
	    tierragroSteps.validarTexto(TierragroPage.getLblNombreProducto(), "Sopladora STIHL BG 86");
	    SeleniumWebDriver.driver.quit();
	}
}
