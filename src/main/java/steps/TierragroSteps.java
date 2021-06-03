package steps;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import driver.SeleniumWebDriver;
import pages.TierragroPage;
import utils.Excel;

public class TierragroSteps {
	
	private static ArrayList<Map<String, String>> lecturaExcel = new ArrayList<Map<String,String>>();

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
	
	public void disminuirZoomPagina (int zooms) {
		
		for (int i = 0; i < zooms; i++) {
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
	}
	
	public void buscarPalabraEnTierragro() {
		
	try {
		Thread.sleep(3000);
		//clickEnElemento(TierragroPage.getBtnCerrarMensaje());
		clickEnElemento(TierragroPage.getBtnAceptarCookie());
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
		
		
		
		try {
			lecturaExcel = Excel.readExcel("C:\\Users\\Ciber\\Documents\\Workspace\\Tierragro\\Productos.xlsx", "Hoja1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//disminuirZoomPagina(1);
		
		for (int i = 0; i < lecturaExcel.size(); i++) {
					
			escribirTexto(TierragroPage.getTxtBuscadorTierragro(), lecturaExcel.get(i).get("Productos"));
			
			try {
				Thread.sleep(1000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(2000);
				clickEnElemento(TierragroPage.getBtnVerProducto());
				
				//scroll
				JavascriptExecutor jse = (JavascriptExecutor)SeleniumWebDriver.driver;
				jse.executeScript("window.scrollBy(0,200)");
				
				Thread.sleep(2000);
				validarTexto(TierragroPage.getLblNombreProducto(), lecturaExcel.get(i).get("Productos"));
				
			} catch (InterruptedException e) {			
				e.printStackTrace();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
