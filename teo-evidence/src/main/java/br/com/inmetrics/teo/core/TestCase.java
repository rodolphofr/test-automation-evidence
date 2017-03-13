package br.com.inmetrics.teo.core;

import java.util.ArrayList;
import java.util.List;

import br.com.inmetrics.teo.core.result.TestCaseResult;

public class TestCase {

	private TestCaseResult testCaseResult;
	private String scene;
	private List<Evidence> evidences;
	
	public TestCase(String scene) {
		this();
		this.scene = scene;
	}
	
	public TestCase() {
		this.evidences = new ArrayList<Evidence>();
		this.testCaseResult = new TestCaseResult(evidences);
	}
	
	public List<Evidence> getEvidences() {
		return evidences;
	}
	
	public TestCaseResult getTestCaseResult() {
		return testCaseResult;
	}
	
	public String getScene() {
		return scene;
	}
	
	public void setScene(String scene) {
		this.scene = scene;
	}
	
	public void putEvidence(Evidence evidence) {
		evidences.add(evidence);
	}
	
}
