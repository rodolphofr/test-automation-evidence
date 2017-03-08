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

import br.com.inmetrics.teo.core.result.TestCaseResult;
import br.com.inmetrics.teo.core.screenshot.SimpleScreenshotType;
/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
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
		log = new EvidenceLog(new SimpleScreenshotType(driver));
	}
	
	@Before
	public void setUp() {
		driver.get("http://www.seleniumhq.org/");
		evidences = new ArrayList<Evidence>();
		newReport = new EvidenceReport.Builder().withEvidences(evidences).withDate(new Date()).build();
	}		
	
	@Test
	public void deveAcessarPaginaSeleniumOrg() {
		newReport.setScene(testName.getMethodName());
		evidences.add(log.passed("Screenshot"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
		newReport.setTestCaseResult(new TestCaseResult(evidences));
		GeneratorEvidenceReport.generate(newReport);
	}

}
