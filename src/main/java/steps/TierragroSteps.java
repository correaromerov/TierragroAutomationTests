package steps;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(2000);
			clickEnElemento(TierragroPage.getBtnVerProducto());
			Thread.sleep(2000);
			validarTexto(TierragroPage.getLblNombreProducto(), palabra);
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
