package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import driver.SeleniumWebDriver;
import pages.TierragroPage;

public class TierragroSteps {

	public void escribirTexto (By elemento, String texto) {
		
		SeleniumWebDriver.driver.findElement(elemento).sendKeys(texto);
	}
	
	public void clickEnElemento (By elemento) {
		
		SeleniumWebDriver.driver.findElement(elemento).click();
	}
	
	public String obtenerTextoDeElemento (By elemento) {
		
		return SeleniumWebDriver.driver.findElement(elemento).getText();
	}
	
	public void validarTexto(By elemento, String texto) {
		
		assertEquals(obtenerTextoDeElemento(elemento), texto);
	}
	
	public void buscarPalabraEnTierragro(String palabra) {
		
		escribirTexto(TierragroPage.getTxtBuscadorTierragro(), palabra);
		try {
			Thread.sleep(5000);
			clickEnElemento(TierragroPage.getBtnBuscar());
			Thread.sleep(5000);
			clickEnElemento(TierragroPage.getBtnVerProducto());
			Thread.sleep(5000);
			validarTexto(TierragroPage.getLblNombreProducto(), palabra);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
