package br.com.inmetrics.teo.core.parse;

public enum Extension {
	PDF("pdf"),
	DOCX("docx"),
	HTML("html"),
	XLS("xls"),
	XLSX("xlsx");
	
	private String name;
	
	private Extension(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
