package br.com.inmetrics.teo.core.screenshot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
/**
 *]
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class SimpleScreenshotType extends AbstractScreenshotType {

	public SimpleScreenshotType(WebDriver driver) {
		super(driver);
	}

	@Override
	public File takeAPicture() {
		return getTakesScreenshot().getScreenshotAs(OutputType.FILE);
	}
	
}
