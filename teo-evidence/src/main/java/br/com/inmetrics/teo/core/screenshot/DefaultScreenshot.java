package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class DefaultScreenshot extends AbstractScreenshot {

	public DefaultScreenshot(WebDriver driver) {
		super(driver);
	}

	@Override
	public File takeAPicture() {
		return ((TakesScreenshot) super.driver).getScreenshotAs(OutputType.FILE);
	}
	
}
