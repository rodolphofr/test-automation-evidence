package br.com.inmetrics.teo.core.parse;

import java.io.OutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class SimpleHtmlExporter implements IExporter {

	@Override
	public void export(JasperPrint print, OutputStream out) throws JRException {
		net.sf.jasperreports.engine.export.HtmlExporter exporter = new net.sf.jasperreports.engine.export.HtmlExporter();
		exporter.setExporterInput(new SimpleExporterInput(print));
		exporter.setExporterOutput(new SimpleHtmlExporterOutput(out));
		exporter.exportReport();
	}
	

}
