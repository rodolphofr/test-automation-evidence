package br.com.inmetrics.teo.core.parse;

import java.io.OutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class SimpleXlsxExporter implements IExporter {

	@Override
	public void export(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
		JRXlsxExporter exporter = new JRXlsxExporter ();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
		exporter.exportReport();
	}

	@Override
	public Extension extensionFile() {
		return Extension.XLSX;
	}

}
