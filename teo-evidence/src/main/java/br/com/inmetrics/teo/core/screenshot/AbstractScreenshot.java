package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.WebDriver;

public abstract class AbstractScreenshot {
	
	protected WebDriver driver;
	
	public AbstractScreenshot(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract File takeAPicture();
	
}
