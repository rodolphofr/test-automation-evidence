package br.com.inmetrics.teo.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static Logger LOGGER = LoggerFactory.getLogger(GeneratorEvidenceReport.class);
	private static Properties properties_report_config;
	private static final String PATH_JR_FILE = "report/evidenceReport.jasper";
	
	static {
		try {
			LOGGER.info("Tentando carregar arquivo [reportconfig.properties].");
			initPropertiesReportConfig();
			LOGGER.info("[reportconfig.properties] foi carregado com sucesso.");
		} catch (IllegalStateException | FileNotFoundException e) {
			LOGGER.error("Erro ao carregar arquivo [reportconfig.properties]", e);
		}
	}
	
	public static void generate(EvidenceReport report) throws GeneratorEvidenceReportException {
		generate(report, JRExporterFactory.getExporterInstance(getExtensionReport()));
	}

	public static void generate(EvidenceReport report, IExporter exporter) throws GeneratorEvidenceReportException {
		
		TestCase testCase = report.getTestCase();
		
		String destination = getProperty("custom.destination.evidence").concat("/") 
																       .concat(testCase.getScene())
																       .concat(".")
																       .concat(getExtensionReport());
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("LABEL_PROJECT", getProperty("label.name.project"));
			parameters.put("LABEL_FACTORY", getProperty("label.factory"));
			parameters.put("LABEL_COD_PROJECT", getProperty("label.cod.project"));
			parameters.put("LABEL_TESTER", getProperty("label.tester"));
			parameters.put("LOGO_CUSTOMER", getProperty("path.logo.customer"));
			parameters.put("LOGO_COMPANY", getProperty("path.logo.company"));
			parameters.put("LABEL_DATE", report.getDate());
			parameters.put("LABEL_SCENE", testCase.getScene());
			parameters.put("LABEL_STATUS_CT", testCase.getTestCaseResult().result());
			
			List<EvidenceView> evidences = EvidenceViewUtils.convertToList(testCase.getEvidences());
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(evidences);
			JasperPrint jasperPrint = JasperFillManager.fillReport(PATH_JR_FILE, parameters, dataSource);
			
			LOGGER.info("Iniciado geração de relatório para o formato " + getExtensionReport());
			exporter.export(jasperPrint, new FileOutputStream(destination));
			LOGGER.info("Exportação finalizada");
			
		} catch (JRException e) {
			throw new GeneratorEvidenceReportException("Erro ocorreu ao gerar relatório do jasper", e);
		} catch (FileNotFoundException e) {
			throw new GeneratorEvidenceReportException("Erro ocorreu ao tentar criar arquivo de evidências. "
					+ "Caminho do arquivo pode estar inválido", e);
		} 
		
	}

	private static String getExtensionReport() {
		return getProperty("file.extension.report");
	}
	
	private static String getProperty(String key) {
		String value = properties_report_config.getProperty(key);
		return StringUtils.isBlank(value) ? StringUtils.EMPTY : value.trim();
	}
	
	private static void initPropertiesReportConfig() throws IllegalStateException, FileNotFoundException {
		properties_report_config = new Properties();
		try {
			properties_report_config.load(new FileInputStream("reportconfig.properties"));
		} catch (FileNotFoundException e) { 
			throw new FileNotFoundException("O arquivo [reportconfig.properties] não foi encontrado. Adicione-o a raiz do seu projeto.");
		} catch (IOException e) {
			throw new IllegalStateException("Exceção inesperada ocorreu ao carregar arquivo properties [reportconfig.properties]", e);
		}
	}
	
}
