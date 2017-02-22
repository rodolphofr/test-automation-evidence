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
	private String imageBase64;  
	
	public Evidence(String description, EvidenceStatus status, File image, Date hour) {
		this.description = description;
		this.status = status;
		this.image = image;
		this.hour = hour;
	}
	
	public Evidence(String description, EvidenceStatus status, String imageBase64, Date hour) {
		this.description = description;
		this.status = status;
		this.imageBase64 = imageBase64;
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
	
	public String getImageBase64() {
		return imageBase64;
	}
	
}
