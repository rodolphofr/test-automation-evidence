package br.com.inmetrics.teo.core;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.inmetrics.teo.core.screenshot.SimpleScreenshotType;
/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class DemoTest {

	private TestCase testCase;
	private static FirefoxDriver driver; 
	private static EvidenceLog log;
	
	@Rule
	public TestName testName = new TestName();
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.gecko.driver", "/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		log = new EvidenceLog(new SimpleScreenshotType(driver));
	}	
	
	@Before
	public void setUp() {
		driver.get("http://www.seleniumhq.org/");
		testCase = new TestCase();
	}		
	
	@Test
	public void testCase1() {
		testCase.setScene(testName.getMethodName());
		testCase.putEvidence(log.passed("screenshot 1"));
		testCase.putEvidence(log.passed("screenshot 2"));
		testCase.putEvidence(log.info("screenshot 3"));
		testCase.putEvidence(log.info("screenshot 4"));
		testCase.putEvidence(log.info("screenshot 5"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
		GeneratorEvidenceReport.generate(testCase);
	}

}
