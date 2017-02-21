package br.com.inmetrics.teo.exceptions;

public class EvidenceReportException extends Exception {

	private static final long serialVersionUID = 1L;

	public EvidenceReportException(String message) {
		super(message);
	}
	
	public EvidenceReportException(String message, Throwable e) {
		super(message, e);
	}
	
}
