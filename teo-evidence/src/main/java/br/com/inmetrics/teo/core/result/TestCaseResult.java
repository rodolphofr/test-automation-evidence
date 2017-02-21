package br.com.inmetrics.teo.core.result;

import java.util.List;

import br.com.inmetrics.teo.core.Evidence;

public class TestCaseResult {
	
	private List<Evidence> evidences;
	
	public void setEvidences(List<Evidence> evidences) {
		this.evidences = evidences;
	}
	
	public Status result() {
		boolean hasEvidenceFail = false;
		
		if (evidences != null) {
			hasEvidenceFail = evidences.stream().filter((e) -> e.isStatus() == false).findFirst().isPresent();
		} 
		
		return hasEvidenceFail ? Status.FAIL : Status.PASSED;
	}
	
}
