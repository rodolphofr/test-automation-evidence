package br.com.inmetrics.teo.core.parse;

import java.io.OutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */

public class SimpleDocxExporter implements IExporter {

	@Override
	public void export(JasperPrint print, OutputStream out) throws JRException {
		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setExporterInput(new SimpleExporterInput(print));	
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
		exporter.exportReport();
	}

	@Override
	public Extension extensionFile() {
		return Extension.DOCX;
	}


}
