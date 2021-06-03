package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Steps;
import steps.TierragroSteps;

public class BuscadorTierragroStepsDefinitions {
	
	@Steps
	TierragroSteps tierragroSteps = new TierragroSteps();

	@Given("^que me encuentro en la pagina de Tierragro con la url (.*)$")
	public void queMeEncuentroEnLaPaginaDeTierragroConLaUrlHttpsWwwTierragroCom(String url) {
		SeleniumWebDriver.chromeWebDriver(url);
	}

	@When("^busco el producto en el buscador$")
	public void buscoElProductoEnElBuscador() {
		tierragroSteps.buscarPalabraEnTierragro();
	}

	@Then("^podre ver el producto en pantalla$")
	public void podreVerElProductoEnPantalla() {
		SeleniumWebDriver.driver.quit();
	}
	
}
