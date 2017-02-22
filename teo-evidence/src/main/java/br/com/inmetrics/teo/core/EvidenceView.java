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
		switch (evidence.getEvidenceStatus()) {
		case FAIL:
			return EvidenceStatus.FAIL.name(); 
		case INFO:
			return EvidenceStatus.PASSED.name();
		case PASSED:
			return EvidenceStatus.INFO.name();
		default:
			return null;
		}
	}
	
	public String getHour() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(evidence.getHour());
	}
	
	public File getImage() {
		return evidence.getImage();
	}
	
}
