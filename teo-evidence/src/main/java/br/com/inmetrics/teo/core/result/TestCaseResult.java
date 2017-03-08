package br.com.inmetrics.teo.core.result;

import java.util.List;

import br.com.inmetrics.teo.core.Evidence;
import br.com.inmetrics.teo.core.EvidenceStatus;
/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
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

	public String result() {
		return checkFail() ? TestResult.FAIL.name() : TestResult.PASSED.name(); 
	}
	
}
