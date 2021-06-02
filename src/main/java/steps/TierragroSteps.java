package steps;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;

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
	
	public void buscarPalabraEnTierragro() {
		
		try {
			lecturaExcel = Excel.readExcel("C:\\Users\\Ciber\\Documents\\Workspace\\Tierragro\\Productos.xlsx", "Hoja1");
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		System.out.println("Productos");
		
		for (int i = 0; i < lecturaExcel.size(); i++) {
			
			System.out.println(lecturaExcel.get(i).get("Productos"));
			
			escribirTexto(TierragroPage.getTxtBuscadorTierragro(), lecturaExcel.get(i).get("Productos"));
			
			try {
				Thread.sleep(2000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(2000);
				clickEnElemento(TierragroPage.getBtnVerProducto());
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
