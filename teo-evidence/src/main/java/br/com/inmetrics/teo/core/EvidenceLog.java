/**
 * 
 */
package br.com.inmetrics.teo.core;

import java.util.Date;

public class EvidenceLog {
	
	public static Evidence passed(String description) {
		return new Evidence(description, EvidenceStatus.PASSED, null, new Date());
	}
	
	public static Evidence fail(String description) {
		return new Evidence(description, EvidenceStatus.FAIL, null, new Date());
	}
	
	public static Evidence info(String description) {
		return new Evidence(description, EvidenceStatus.INFO, null, new Date());
	}
	
}
