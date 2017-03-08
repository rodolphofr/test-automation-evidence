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
	
	public void setTestCaseResult(TestCaseResult testCaseResult) {
		this.testCaseResult = testCaseResult;
	}
	
	public static class Builder {
		
		private Date date;
		private TestCaseResult testCaseResult;
		private String scene;
		private List<Evidence> evidences;
		
		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}
		
		public Builder withTestCaseResult(TestCaseResult testCaseResult) {
			this.testCaseResult = testCaseResult;
			return this;
		}
		
		public Builder withScene(String scene) {
			this.scene = scene;
			return this;
		}
		
		public Builder withEvidences(List<Evidence> evidences) {
			this.evidences = evidences;
			return this;
		}
		
		public EvidenceReport build() {
			EvidenceReport report = new EvidenceReport();
			report.setDate(this.date);
			report.setEvidences(this.evidences);
			report.setScene(this.scene);
			report.setTestCaseResult(this.testCaseResult);
			return report;
		}
		
	}
	
}
