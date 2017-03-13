package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public abstract class AbstractScreenshotType {
	
	protected WebDriver driver;
	protected TakesScreenshot takesScreenshot;
	
	public AbstractScreenshotType(WebDriver driver) {
		this.driver = driver;
		this.takesScreenshot = ((TakesScreenshot) driver);
	}
	
	public abstract File takeAPicture();
	
	public TakesScreenshot getTakesScreenshot() {
		return takesScreenshot;
	}
	
}
