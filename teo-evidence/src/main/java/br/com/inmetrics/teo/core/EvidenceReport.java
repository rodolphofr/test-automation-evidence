package br.com.inmetrics.teo.core;

import java.util.Date;
import java.util.List;

import br.com.inmetrics.teo.core.result.TestCaseResult;

/**
 * @author Rodolpho F. Rodrigues
 */
public class EvidenceReport {

	private final Date date;
	private final TestCaseResult testCaseResult = null;
	private final String scene;
	private final List<Evidence> evidences;
	
	public EvidenceReport(List<Evidence> evidences, String scene, Date date) {
		this.evidences = evidences;
		this.scene = scene;
		this.date = date;
	}

	public String getScene() {
		return scene;
	}

	public Date getDate() {
		return date;
	}

	public List<Evidence> getEvidences() {
		return evidences;
	}
	
	public TestCaseResult getTestCaseResult() {
		return testCaseResult;
	}

	
}
