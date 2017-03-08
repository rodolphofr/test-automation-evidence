package br.com.inmetrics.teo.core;

import java.util.Date;
import java.util.List;

import br.com.inmetrics.teo.core.result.TestCaseResult;

/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class EvidenceReport {

	private Date date;
	private TestCaseResult testCaseResult;
	private String scene;
	private List<Evidence> evidences;
	
	public EvidenceReport(List<Evidence> evidences, String scene, Date date) {
		this.evidences = evidences;
		this.scene = scene;
		this.date = date;
		this.testCaseResult = new TestCaseResult(evidences);
	}

	public EvidenceReport(List<Evidence> evidences, Date date) {
		this(evidences, null, date);
	}
	
	public EvidenceReport(List<Evidence> evidences, Date date, TestCaseResult testCaseResult) {
		this(evidences, date);
		this.testCaseResult = testCaseResult;
	}
	
	public EvidenceReport(List<Evidence> evidences, String scene, Date date, TestCaseResult testCaseResult) {
		this(evidences, date, testCaseResult);
		this.scene = scene;
	}
	
	public EvidenceReport() {
		
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

	public void setScene(String scene) {
		this.scene = scene;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setEvidences(List<Evidence> evidences) {
		this.evidences = evidences;
	}
	
}
