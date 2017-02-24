package br.com.inmetrics.teo.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.inmetrics.teo.core.screenshot.SimpleScreenshotConfigurationTypeFile;

public class DemoTest {

	private List<Evidence> evidences;
	private EvidenceReport newReport;
	private static EvidenceLog log;
	private static FirefoxDriver driver; 
	
	@Rule
	public TestName testName = new TestName();
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		log = new EvidenceLog(new SimpleScreenshotConfigurationTypeFile(driver));
	}
	
	@Before
	public void setUp() {
		driver.get("http://www.seleniumhq.org/");
		evidences = new ArrayList<Evidence>();
		newReport = new EvidenceReport(evidences, new Date());
	}
	
	@Test
	public void deveAcessarPaginaSeleniumOrg() {
		newReport.setScene(testName.getMethodName());
		evidences.add(log.passed("Tirado foto"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
		GeneratorEvidenceReport.generate(newReport);
	}

}
