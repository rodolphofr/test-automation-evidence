package br.com.inmetrics.teo.core.factory;

import br.com.inmetrics.teo.core.parse.IExporter;
import br.com.inmetrics.teo.core.parse.SimpleDocxExporter;
import br.com.inmetrics.teo.core.parse.SimpleHtmlExporter;
import br.com.inmetrics.teo.core.parse.SimplePdfExporter;
import br.com.inmetrics.teo.core.parse.SimpleXlsxExporter;
import br.com.inmetrics.teo.exceptions.GeneratorEvidenceReportException;

public class JRExporterFactory {

	public static IExporter getExporterInstance(String fileExtensionReport) {
		
		switch (fileExtensionReport.toLowerCase()) {
			case "docx":
				return new SimpleDocxExporter();
			case "pdf":
				return new SimplePdfExporter();
			case "html":
				return new SimpleHtmlExporter();
			case "xlsx":
				return new SimpleXlsxExporter();
			default:
				throw new GeneratorEvidenceReportException("A exteção do arquivo de saída do relatório é inválida. "
						+ "Verique o valor informado no arquivo reportconfig.properties.");
		}
		
	}
	
}
