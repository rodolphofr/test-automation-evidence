package br.com.inmetrics.teo.core.screenshot;

import org.openqa.selenium.WebDriver;

public abstract class AbstractScreenshotConfigurationType<T> {
	
	protected WebDriver driver;
	
	public AbstractScreenshotConfigurationType(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract T takeAPicture();
	
}
