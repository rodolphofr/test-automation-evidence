/**
 * 
 */
package br.com.inmetrics.teo.core;

import java.util.Date;

import br.com.inmetrics.teo.core.screenshot.AbstractScreenshotType;

public class EvidenceFactory {

	private AbstractScreenshotType screenshotType;

	public EvidenceFactory(AbstractScreenshotType screenshotType) {
		this.screenshotType = screenshotType;
	}

	public Evidence passed(String description) {
		return new Evidence(description, EvidenceStatus.PASSED, screenshotType.takeAPicture(), new Date());
	}

	public Evidence fail(String description) {
		return new Evidence(description, EvidenceStatus.FAIL, screenshotType.takeAPicture(), new Date());
	}

	public Evidence info(String description) {
		return new Evidence(description, EvidenceStatus.INFO, screenshotType.takeAPicture(), new Date());
	}

}
