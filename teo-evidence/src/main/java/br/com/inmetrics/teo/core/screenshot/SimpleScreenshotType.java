package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.WebDriver;

public class SimpleScreenshotType extends AbstractScreenshotType {

	public SimpleScreenshotType(WebDriver driver) {
		super(driver);
	}

	@Override
	public File takeAPicture() {
		return super.screenshotAsFile();
	}
	
}
