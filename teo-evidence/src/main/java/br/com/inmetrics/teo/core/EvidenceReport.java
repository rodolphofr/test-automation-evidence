package br.com.inmetrics.teo.core;

import java.util.Date;

/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class EvidenceReport {

	private TestCase testCase;
	private Date date;
	
	public EvidenceReport(TestCase testCase, Date date) {
		this.testCase = testCase;
		this.date = date;
	}
	
	public EvidenceReport() {
		
	}
	
	public Date getDate() {
		return date;
	}
	
	public TestCase getTestCase() {
		return testCase;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}
	
}
