/**
 * 
 */
package br.com.inmetrics.teo.core;

import java.util.Date;

import br.com.inmetrics.teo.core.screenshot.AbstractScreenshotConfigurationType;

public class EvidenceFactory {

	private AbstractScreenshotConfigurationType screenshot;

	public EvidenceFactory(AbstractScreenshotConfigurationType screenshotType) {
		this.screenshot = screenshotType;
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
