package br.com.inmetrics.teo.core.parse;

import java.io.OutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface IExporter {
	void export(JasperPrint jasperPrint, OutputStream outputStream) throws JRException;
}
