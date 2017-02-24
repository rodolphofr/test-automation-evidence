/**
 * 
 */
package br.com.inmetrics.teo.core;

import java.io.File;
import java.util.Date;

import br.com.inmetrics.teo.core.screenshot.AbstractScreenshotConfigurationType;

public class EvidenceLog {
	
	private AbstractScreenshotConfigurationType<?> screenshotConfigurationType; 
	
	public EvidenceLog(AbstractScreenshotConfigurationType<?> screenshotConfigurationType) {
		this.screenshotConfigurationType = screenshotConfigurationType;
	}
	
	public Evidence passed(String description) {
		return this.log(description, EvidenceStatus.PASSED);
	}
	
	public Evidence fail(String description) {
		return this.log(description, EvidenceStatus.FAIL);
	}
	
	public Evidence info(String description) {
		return this.log(description, EvidenceStatus.INFO);
	}
	
	private Evidence log(String description, EvidenceStatus status) {
		Object screenshot = screenshotConfigurationType.takeAPicture();
		Date hour = new Date();
		
		if (screenshot instanceof File) {
			return new Evidence(description, status, (File)screenshot, hour);
		} 
		if (screenshot instanceof String) {
			return new Evidence(description, status, (String)screenshot, hour); 
		}
		
		return null;
	}
}
