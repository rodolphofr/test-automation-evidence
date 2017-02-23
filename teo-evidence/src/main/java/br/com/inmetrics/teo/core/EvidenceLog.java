/**
 * 
 */
package br.com.inmetrics.teo.core;

import java.util.Date;

import br.com.inmetrics.teo.core.screenshot.Screenshot;

public class EvidenceLog {
	
	private Screenshot screenshot;

	public EvidenceLog(Screenshot screenshot) {
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

}
