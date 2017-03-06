package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

public class SimpleScreenshotConfigurationType extends AbstractScreenshotConfigurationType {

	public SimpleScreenshotConfigurationType(WebDriver driver) {
		super(driver);
	}

	@Override
	public File takeAPicture() {
		return super.getTakesScreenshot().getScreenshotAs(OutputType.FILE);
	}
	
}
