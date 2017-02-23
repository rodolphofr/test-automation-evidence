package br.com.inmetrics.teo.core;

import java.io.File;
import java.util.Date;

/**
 * @author Rodolpho F. Rodrigues
 */
public class Evidence {

	private Date hour;
	private File image;
	private EvidenceStatus status;
	private String description;
	
	public Evidence(String description, EvidenceStatus status, File image, Date hour) {
		this.description = description;
		this.status = status;
		this.image = image;
		this.hour = hour;
	}
	
	public String getDescription() {
		return description;
	}
	
	public EvidenceStatus getEvidenceStatus() {
		return status;
	}
	
	public File getImage() {
		return image;
	}
	
	public Date getHour() {
		return hour;
	}
	
}
