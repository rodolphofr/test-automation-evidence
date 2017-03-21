package br.com.inmetrics.teo.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
	
	static {
		initPropertiesReportConfig();
	}
	
	private static Properties propertiesReportConfig;
	private static String extensionReport = propertiesReportConfig.getProperty("file.extension.report"); 
	private static final String PATH_JR_FILE = "report/evidenceReport.jasper";

	public static void generate(TestCase testcase, IExporter exporter) throws GeneratorEvidenceReportException {
		
		String destination = propertiesReportConfig.getProperty("custom.destination.evidence")
													 .concat("/") 
													 .concat(testcase.getScene())
													 .concat(".")
													 .concat(exporter.extensionFile().getName());
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("LABEL_PROJECT", propertiesReportConfig.getProperty("label.name.project"));
			parameters.put("LABEL_FACTORY", propertiesReportConfig.getProperty("label.factory"));
			parameters.put("LABEL_COD_PROJECT", propertiesReportConfig.getProperty("label.cod.project"));
			parameters.put("LABEL_TESTER", propertiesReportConfig.getProperty("label.tester"));
			parameters.put("LOGO_CUSTOMER", propertiesReportConfig.getProperty("path.logo.customer"));
			parameters.put("LOGO_COMPANY", propertiesReportConfig.getProperty("path.logo.company"));
			parameters.put("LABEL_DATE", new Date());
			parameters.put("LABEL_SCENE", testcase.getScene());
			parameters.put("LABEL_STATUS_CT", testcase.getTestCaseResult().result());
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(EvidenceViewUtils.convertToList(testcase.getEvidences()));
			JasperPrint jasperPrint = JasperFillManager.fillReport(PATH_JR_FILE, parameters, dataSource);
			
			exporter.export(jasperPrint, new FileOutputStream(destination));
			
		} catch (JRException e) {
			throw new GeneratorEvidenceReportException("Erro ocorreu ao gerar relatório do jasper", e);
		} catch (FileNotFoundException e) {
			throw new GeneratorEvidenceReportException("Erro ocorreu ao tentar criar arquivo de evidências. "
					+ "Caminho do arquivo pode estar inválido", e);
		} 
		
	}

	public static void generate(TestCase testCase) throws GeneratorEvidenceReportException {
		IExporter exporter = JRExporterFactory.getExporterInstance(extensionReport);
		generate(testCase, exporter);
	}
	
	private static void initPropertiesReportConfig() {
		propertiesReportConfig = new Properties();
		
		try {
			propertiesReportConfig.load(new FileInputStream("resources/reportconfig.properties"));
		} catch (FileNotFoundException e) {
			throw new GeneratorEvidenceReportException(e);
		} catch (IOException e) {
			throw new GeneratorEvidenceReportException(e);
		}
		
	}
	
}
