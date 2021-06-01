package pages;

import org.openqa.selenium.By;

public class TierragroPage {

	private static By txtBuscadorTierragro = By.xpath("//input[@class='search-bar__input']");
	private static By btnInicioTierragro = By.xpath("//img[@class=\'header__logo-image\']");
	private static By btnVerProducto = By.xpath("//a[@class=\'temporalBuyButton\']");
	private static By lblNombreProducto = By.xpath("//h1[@class=\'product-meta__title heading h1\']");
	private static By btnBuscar = By.xpath("//button[@class=\'search-bar__submit\']");
	private static By btnCerrarMensaje = By.xpath("//i[@class='far fa-times close triggerClose']");
//	private static By btnCerrarMensaje = By.xpath("//div[@class='powrModal popupApp animate-entrance ']");
	
	public static By getTxtBuscadorTierragro() {
		return txtBuscadorTierragro;
	}
	public static By getBtnInicioTierragro() {
		return btnInicioTierragro;
	}
	public static By getBtnVerProducto() {
		return btnVerProducto;
	}
	public static By getLblNombreProducto() {
		return lblNombreProducto;
	}
	public static By getBtnBuscar() {
		return btnBuscar;
	}
	public static By getBtnCerrarMensaje() {
		return btnCerrarMensaje;
	}
	
}
