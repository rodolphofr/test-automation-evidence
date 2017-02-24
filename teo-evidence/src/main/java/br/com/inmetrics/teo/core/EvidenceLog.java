/**
 * 
 */
package br.com.inmetrics.teo.core;

import java.io.File;
import java.util.Date;

import br.com.inmetrics.teo.core.screenshot.AbstractScreenshot;

public class EvidenceLog {
	
	private AbstractScreenshot screenshot; 
	
	public EvidenceLog(AbstractScreenshot screenshot) {
		this.screenshot = screenshot;
	}
	
	public Evidence passed(String description) {
		return new Evidence(description, EvidenceStatus.PASSED, screenshot.takeAPicture(), new Date());
	}
	
	public Evidence fail(String description) {
		return new Evidence(description, EvidenceStatus.FAIL, screenshot.takeAPicture(), new Date());
	}
	
	public Evidence info(String description) {
		return new Evidence(description, EvidenceStatus.INFO, screenshot.takeAPicture(), new Date());
	}
	
	private Evidence log(String description, Object screenshot) {
		if (screenshot instanceof File) {
			return new Evidence(description, EvidenceStatus.INFO, (File) screenshot, new Date());
		} else if (screenshot instanceof String) {
			return new Evidence(description, EvidenceStatus.INFO, (String) screenshot, new Date()); 
		}
		return null;
	}
}
