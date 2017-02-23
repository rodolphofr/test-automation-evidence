package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	private WebDriver driver;
	private IScreenshotConfiguration configuration;
	
	public Screenshot(WebDriver driver, IScreenshotConfiguration configuration) {
		this.driver = driver;
		this.configuration = configuration;
	}
	
	public Screenshot(WebDriver driver) {
		this.driver = driver;
		this.configuration = new SimpleScreenshotConfiguration();
	}
	
	public File takeAPicture() {
		this.sizeOf(configuration.getZoomIn());
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		this.sizeOf(configuration.getZoomOut());
		return screenshot;
	}
	
	private void sizeOf(int zoom) {
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='" + zoom + "%'");
	}
	
	
}
