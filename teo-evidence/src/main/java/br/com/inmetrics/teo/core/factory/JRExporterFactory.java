package br.com.inmetrics.teo.core.factory;

import br.com.inmetrics.teo.core.parse.IExporter;
import br.com.inmetrics.teo.core.parse.DocxExporter;
import br.com.inmetrics.teo.core.parse.HtmlExporter;
import br.com.inmetrics.teo.core.parse.PdfExporter;
import br.com.inmetrics.teo.exceptions.GeneratorEvidenceReportException;

public class JRExporterFactory {

	public static IExporter getExporterInstance(String fileExtensionReport) {
		
		switch (fileExtensionReport.toLowerCase()) {
			case "docx":
				return new DocxExporter();
			case "pdf":
				return new PdfExporter();
			case "html":
				return new HtmlExporter();
			default:
				throw new GeneratorEvidenceReportException("A exteção do arquivo de saída do relatório é inválida. "
						+ "Verique o valor informado no arquivo reportconfig.properties.");
		}
		
	}
	
}
