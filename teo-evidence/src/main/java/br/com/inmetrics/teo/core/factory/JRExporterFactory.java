package br.com.inmetrics.teo.core.factory;

import br.com.inmetrics.teo.core.parse.IExporter;
import br.com.inmetrics.teo.core.parse.DocxExporter;
import br.com.inmetrics.teo.core.parse.HtmlExporter;
import br.com.inmetrics.teo.core.parse.PdfExporter;
import br.com.inmetrics.teo.exceptions.GeneratorEvidenceReportException;

public class JRExporterFactory {

	public static IExporter getExporterInstance(String extension) {
		
		switch (extension.toLowerCase()) {
			case "docx":
				return new DocxExporter();
			case "pdf":
				return new PdfExporter();
			case "html":
				return new HtmlExporter();
			default:
				throw new GeneratorEvidenceReportException("Ainda não foi implementado Exporter para a extensão [" + extension + "].");
		}
		
	}
	
}
