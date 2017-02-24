package br.com.inmetrics.teo.core.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SimpleScreenshotConfigurationTypeBase64 extends AbstractScreenshotConfigurationType<String>{

	public SimpleScreenshotConfigurationTypeBase64(WebDriver driver) {
		super(driver);
	}

	@Override
	public String takeAPicture() {
		return ((TakesScreenshot) super.driver).getScreenshotAs(OutputType.BASE64);
	}

}
