package br.com.inmetrics.teo.exceptions;
/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class GeneratorEvidenceReportException extends RuntimeException {

	private static final long serialVersionUID = -8726267979423664897L;

	public GeneratorEvidenceReportException(String message) {
		super(message);
	}
	
	public GeneratorEvidenceReportException(String message, Throwable e) {
		super(message, e);
	}

	public GeneratorEvidenceReportException(Throwable e) {
		super(e);
	}
	
}
