/**
 * 
 */
package br.com.inmetrics.teo.core;

import java.util.Date;

import br.com.inmetrics.teo.core.screenshot.AbstractScreenshotType;

/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class EvidenceLog {

	private AbstractScreenshotType screenshotType;

	public EvidenceLog(AbstractScreenshotType screenshotType) {
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
