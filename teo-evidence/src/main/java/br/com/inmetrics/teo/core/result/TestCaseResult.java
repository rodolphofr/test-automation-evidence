package br.com.inmetrics.teo.core.result;

import java.util.List;

import br.com.inmetrics.teo.core.Evidence;
import br.com.inmetrics.teo.core.EvidenceStatus;

public class TestCaseResult {

	private List<Evidence> evidences;
	
	public TestCaseResult(List<Evidence> evidences) {
		this.evidences = evidences;
	}
	
	private boolean checkFail() {
		return evidences.stream()
						.filter((e) -> e.getEvidenceStatus() == EvidenceStatus.FAIL)
						.findFirst()
						.isPresent();
	}

	public TestResult result() {
		return checkFail() ? TestResult.FAIL : TestResult.PASSED; 
	}
	
}
