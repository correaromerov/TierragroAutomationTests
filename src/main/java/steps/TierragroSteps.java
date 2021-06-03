package steps;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import driver.SeleniumWebDriver;
import pages.TierragroPage;
import utils.Excel;

public class TierragroSteps {
	
	private static ArrayList<Map<String, String>> lecturaExcel = new ArrayList<Map<String,String>>();

	public static String defaultWindows;
	
	public void escribirTexto (By elemento, String texto) {
		
		boolean validarElemento = false;
		while (validarElemento == false) {
			try {
				SeleniumWebDriver.driver.findElement(elemento).sendKeys(texto);
				validarElemento = true;
			} catch (Exception e) {
				
			}			
		}
	}
	
	public void clickEnElemento (By elemento) {
				
		boolean validarElemento = false;
		while (validarElemento == false) {
			try {
				SeleniumWebDriver.driver.findElement(elemento).click();
				validarElemento = true;
			} catch (Exception e) {
				
			}			
		}
	}
	
	public String obtenerTextoDeElemento (By elemento) {
		
		boolean validarElemento = false;
		String textElemento = "";
		while (validarElemento == false) {
			try {
				textElemento = SeleniumWebDriver.driver.findElement(elemento).getText();
				validarElemento = true;
			} catch (Exception e) {
				
			}			
		}
		return textElemento;
	}
	
	public void validarTexto(By elemento, String texto) {
		
		boolean validarTexto = false;
		if(obtenerTextoDeElemento(elemento).contains(texto)) {
			validarTexto = true;
		}
		assertEquals(true, validarTexto);
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
				
		boolean cerroCookie = false;
				
		try {
			lecturaExcel = Excel.readExcel("C:\\Users\\Ciber\\Documents\\Workspace\\Tierragro\\Productos.xlsx", "Hoja1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//disminuirZoomPagina(3);
		
		for (int i = 0; i < lecturaExcel.size(); i++) {
					
			escribirTexto(TierragroPage.getTxtBuscadorTierragro(), lecturaExcel.get(i).get("Productos"));
			
			try {
				Thread.sleep(1000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				if (!cerroCookie) {
					clickEnElemento(TierragroPage.getBtnAceptarCookie());
					cerroCookie = true;
				}
				
				clickEnElemento(TierragroPage.getBtnVerProducto());
				
				//scroll
				JavascriptExecutor jse = (JavascriptExecutor)SeleniumWebDriver.driver;
				jse.executeScript("window.scrollBy(0,200)");
				
				validarTexto(TierragroPage.getLblNombreProducto(), lecturaExcel.get(i).get("Productos"));
				
			} catch (InterruptedException e) {			
				e.printStackTrace();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void cambiarmeDeVentana() {
		defaultWindows = SeleniumWebDriver.driver.getWindowHandle();
		System.out.println("Default: " + defaultWindows);
		Set<String> lista = SeleniumWebDriver.driver.getWindowHandles();
		Iterator<String> I1 = lista.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			System.out.println("Child: " + child_window);
			if(!defaultWindows.equals(child_window)) {
				SeleniumWebDriver.driver.switchTo().window(child_window);
				System.out.println("Cambio ventana");
			}
		}
		
	}
	
	public static void volverALaVentanaPrincipal () {
		SeleniumWebDriver.driver.switchTo().window(defaultWindows);
	}
}
