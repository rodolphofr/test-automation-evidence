package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Rodolpho F. Rodrigues (Inmetrics)
 *
 */
public abstract class AbstractScreenshotConfigurationType {
	
	protected WebDriver driver;
	protected TakesScreenshot takesScreenshot;
	
	public AbstractScreenshotConfigurationType(WebDriver driver) {
		this.driver = driver;
		this.takesScreenshot = ((TakesScreenshot) driver);
	}
	
	public abstract File takeAPicture();
	
	public TakesScreenshot getTakesScreenshot() {
		return takesScreenshot;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
