package br.com.inmetrics.teo.core;

import br.com.inmetrics.teo.exceptions.GeneratorEvidenceReportException;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.Exporter;

public class JRExporterFactory {

	@SuppressWarnings("rawtypes")
	public static Exporter getExporterInstance(String fileExtensionReport) {
		
		switch (fileExtensionReport.toLowerCase()) {
			case "docx":
				return new JRDocxExporter();
			case "pdf":
				return new JRPdfExporter();
			case "html":
				return new HtmlExporter();
			default:
				throw new GeneratorEvidenceReportException("A exteção do arquivo de saída do relatório é inválida. "
						+ "Verique o valor informado no arquivo reportconfig.properties.");
		}
		
	}
	
}
