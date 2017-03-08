package br.com.inmetrics.teo.core;

import java.io.File;
import java.text.SimpleDateFormat;

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
		return evidence.getEvidenceStatus().name();
	}
	
	public String getHour() {
		return new SimpleDateFormat("HH:mm:ss").format(evidence.getHour());
	}
	
	public File getImage() {
		return evidence.getImage();
	}
	
	public void setEvidence(Evidence evidence) {
		this.evidence = evidence;
	}
	
}
