package br.com.inmetrics.teo.core;

import java.io.File;
import java.text.SimpleDateFormat;

import br.com.inmetrics.teo.core.result.Status;

public class EvidenceView {

	private Evidence evidence;
	
	public EvidenceView(Evidence evidence) {
		this.evidence = evidence;
	}
	
	public EvidenceView() {
		
	}

	public String getDescription() {
		return evidence.getDescription();
	}
	
	public String getStatus() {
		return evidence.isStatus() ? Status.PASSED.name() : Status.FAIL.name();
	}
	
	public String getHour() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(evidence.getHour());
	}
	
	public File getImage() {
		return evidence.getImage();
	}
	
}
