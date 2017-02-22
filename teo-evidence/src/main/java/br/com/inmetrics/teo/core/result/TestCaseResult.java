package br.com.inmetrics.teo.core.result;

import java.util.List;

import br.com.inmetrics.teo.core.Evidence;

public class TestCaseResult {

	private List<Evidence> evidences;
	
	public TestCaseResult(List<Evidence> evidences) {
		this.evidences = evidences;
	}
	
	private boolean checkFail() {
		return evidences.stream()
						.filter((e) -> e.isStatus() == false)
						.findFirst()
						.isPresent();
	}

	public String getResultStatus() {
		return checkFail() ? Status.FAIL.name() : Status.PASSED.name(); 
	}
	
}
