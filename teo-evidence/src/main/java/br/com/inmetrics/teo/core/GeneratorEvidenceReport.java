package br.com.inmetrics.teo.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import br.com.inmetrics.teo.core.factory.JRExporterFactory;
import br.com.inmetrics.teo.core.parse.IExporter;
import br.com.inmetrics.teo.exceptions.GeneratorEvidenceReportException;
import br.com.inmetrics.teo.utils.EvidenceViewUtils;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class GeneratorEvidenceReport {
	
	private static Properties properties_report_config;
	private static final String PATH_JR_FILE = "report/evidenceReport.jasper";

	static {
		initPropertiesReportConfig();
	}
	
	public static void generate(EvidenceReport report, OutputStream outputFile) throws GeneratorEvidenceReportException {
		generate(report, outputFile, getExporter());
	}
	
	public static void generate(EvidenceReport report, IExporter exporter) throws GeneratorEvidenceReportException {
		generate(report, getDefaultOutputFile(report.getScene()), exporter);
	}
	
	public static void generate(EvidenceReport report) throws GeneratorEvidenceReportException {
		generate(report, getDefaultOutputFile(report.getScene()), getExporter());
	}

	public static void generate(EvidenceReport report, OutputStream outputFile, IExporter exporter) throws GeneratorEvidenceReportException {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("LABEL_PROJECT", getProperty("label.name.project"));
			parameters.put("LABEL_FACTORY", getProperty("label.factory"));
			parameters.put("LABEL_COD_PROJECT", getProperty("label.cod.project"));
			parameters.put("LABEL_TESTER", getProperty("label.tester"));
			parameters.put("LOGO_CUSTOMER", getProperty("path.logo.customer"));
			parameters.put("LOGO_COMPANY", getProperty("path.logo.company"));
			parameters.put("LABEL_DATE", report.getDate());
			parameters.put("LABEL_SCENE", report.getScene());
			parameters.put("LABEL_STATUS_CT", report.getTestCaseResult().result());
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(EvidenceViewUtils.convertToList(report.getEvidences()));
			JasperPrint jasperPrint = JasperFillManager.fillReport(PATH_JR_FILE, parameters, dataSource);
			
			exporter.export(jasperPrint, outputFile);
			
		} catch (JRException e) {
			throw new GeneratorEvidenceReportException("Exceção ocorreu ao tentar gerar relatório do jasper: " + e.getMessage(), e);
		} 
		
	}

	private static FileOutputStream getDefaultOutputFile(String scene) throws GeneratorEvidenceReportException {
		
		try {
			String destination = getProperty("custom.destination.evidence").concat("/") 
																	       .concat(scene)
																	       .concat(".")
																	       .concat(getExtensionReport());
			return new FileOutputStream(destination);
		} catch (FileNotFoundException e) {
			throw new GeneratorEvidenceReportException("Exceção ocorreu ao tentar criar arquivo de evidências. "
					+ "Caminho do arquivo pode estar inválido: " + e.getMessage(), e);
		}
	}
	
	private static IExporter getExporter() {
		return JRExporterFactory.getExporterInstance(getExtensionReport());
	}
	
	private static String getExtensionReport() {
		return getProperty("file.extension.report");
	}
	
	private static String getProperty(String key) {
		String value = properties_report_config.getProperty(key);
		return StringUtils.isBlank(value) ? StringUtils.EMPTY : value.trim();
	}
	
	private static void initPropertiesReportConfig() throws IllegalStateException {
		properties_report_config = new Properties();
		try {
			properties_report_config.load(new FileInputStream("reportconfig.properties"));
		} catch (IOException e) {
			throw new IllegalStateException("Exceção inesperada ocorreu ao carregar arquivo properties [reportconfig.properties]", e);
		}
	}
	
}
