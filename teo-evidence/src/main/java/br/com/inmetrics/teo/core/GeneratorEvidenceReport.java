package br.com.inmetrics.teo.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

/**
 * @author Rodolpho F. Rodrigues
 */
public class GeneratorEvidenceReport {

	private static Properties PROPERTIES_REPORT_CONFIG;
	
	static {
		initPropertiesReportConfig();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void generate(EvidenceReport report) {
		
		try {
			
			String destinationEvidence = PROPERTIES_REPORT_CONFIG.getProperty("destination.evidence");
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("LABEL_PROJECT", PROPERTIES_REPORT_CONFIG.getProperty("label.name.project"));
			parameters.put("LABEL_FACTORY", PROPERTIES_REPORT_CONFIG.getProperty("label.factory"));
			parameters.put("LABEL_COD_PROJECT", PROPERTIES_REPORT_CONFIG.getProperty("label.cod.project"));
			parameters.put("LABEL_TESTER", PROPERTIES_REPORT_CONFIG.getProperty("label.tester"));
			parameters.put("LOGO_CUSTOMER", PROPERTIES_REPORT_CONFIG.getProperty("path.logo.customer"));
			parameters.put("LOGO_CORPORATION", PROPERTIES_REPORT_CONFIG.getProperty("path.logo.corporation"));
			parameters.put("LABEL_DATE", report.getDate());
			parameters.put("LABEL_SCENE", report.getScene());
			parameters.put("LABEL_STATUS_CT", report.getTestCaseResult().result().name());
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(EvicenceViewUtils.convertToList(report.getEvidences()));
			JasperPrint jasperPrint = JasperFillManager.fillReport("report/evidenceReport.jasper", parameters, dataSource);
			
			Exporter exporter = JRExporterFactory.getExporterInstance(PROPERTIES_REPORT_CONFIG.getProperty("file.extension.report"));
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));	
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(destinationEvidence)));
			exporter.exportReport();
			
		} catch (JRException e) {
			throw new GeneratorEvidenceReportException("Alguma exceção ocorreu ao tentar gerar relatório do jasper: " + e.getMessage(), e);
		} catch (FileNotFoundException e) {
			throw new GeneratorEvidenceReportException("Alguma exceção ocorreu ao tentar criar arquivo de evidências: " + e.getMessage(), e);
		}
		
	}
	
	private static void initPropertiesReportConfig() {
		PROPERTIES_REPORT_CONFIG = new Properties();
		try {
			PROPERTIES_REPORT_CONFIG.load(new FileInputStream("reportconfig.properties"));
		} catch (IOException e) {
			throw new IllegalStateException("Exceção inesperada ocorreu ao carregar arquivo properties [reportconfig.properties]", e);
		}
	}
	
}
