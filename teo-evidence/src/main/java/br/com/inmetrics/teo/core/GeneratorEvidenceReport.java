package br.com.inmetrics.teo.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import br.com.inmetrics.teo.exceptions.GeneratorEvidenceReportException;
import br.com.inmetrics.teo.utils.EvicenceViewUtils;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class GeneratorEvidenceReport {
	
	private static Properties properties_report_config;
	private static final String PATH_JR_FILE = "report/evidenceReport.jasper";

	static {
		initPropertiesReportConfig();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void generate(EvidenceReport report) {
		
		try {
			
			String fileExtensionReport = getProperty("file.extension.report");
			String destinationEvidence = createPathDestinationEvidence(report, fileExtensionReport);
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("LABEL_PROJECT", getProperty("label.name.project"));
			parameters.put("LABEL_FACTORY", getProperty("label.factory"));
			parameters.put("LABEL_COD_PROJECT", getProperty("label.cod.project"));
			parameters.put("LABEL_TESTER", getProperty("label.tester"));
			parameters.put("LOGO_CUSTOMER", getProperty("path.logo.customer"));
			parameters.put("LOGO_CORPORATION", getProperty("path.logo.corporation"));
			parameters.put("LABEL_DATE", report.getDate());
			parameters.put("LABEL_SCENE", report.getScene());
			parameters.put("LABEL_STATUS_CT", report.getTestCaseResult().getResultStatus());
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(EvicenceViewUtils.convertToList(report.getEvidences()));
			JasperPrint jasperPrint = JasperFillManager.fillReport(PATH_JR_FILE, parameters, dataSource);
			
			Exporter exporter = JRExporterFactory.getExporterInstance(fileExtensionReport);
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));	
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(destinationEvidence)));
			exporter.exportReport();
			
		} catch (JRException e) {
			throw new GeneratorEvidenceReportException("Exceção ocorreu ao tentar gerar relatório do jasper: " + e.getMessage(), e);
		} catch (FileNotFoundException e) {
			throw new GeneratorEvidenceReportException("Exceção ocorreu ao tentar criar arquivo de evidências: " + e.getMessage(), e);
		}
		
	}
	
	private static void initPropertiesReportConfig() {
		properties_report_config = new Properties();
		try {
			properties_report_config.load(new FileInputStream("reportconfig.properties"));
		} catch (IOException e) {
			throw new IllegalStateException("Exceção inesperada ocorreu ao carregar arquivo properties [reportconfig.properties]", e);
		}
	}
	
	private static String getProperty(String key) {
		String value = properties_report_config.getProperty(key);
		return StringUtils.isBlank(value) ? StringUtils.EMPTY : value.trim();
	}
	
	private static String createPathDestinationEvidence(EvidenceReport report, String fileExtensionReport) {
		return getProperty("custom.destination.evidence") + "/" + report.getScene() + "." + fileExtensionReport;
	}
	
}
