package br.com.inmetrics.teo.core;

import java.io.File;
import java.text.SimpleDateFormat;

import br.com.inmetrics.teo.utils.FileUtils;

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
		String imageBase64 = evidence.getImageBase64();
		
		if (imageBase64 != null) {
			return FileUtils.base64ToTempFile(imageBase64);
		}
		
		return evidence.getImage();
	}
	
}
