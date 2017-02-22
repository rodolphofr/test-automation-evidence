package br.com.inmetrics.teo.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(JUnitPlatform.class)
public class DemoAutomationTest {

	private List<Evidence> evidences;
	private FirefoxDriver driver; 
	
	private EvidenceReport newReport;
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.seleniumhq.org/");
		evidences = new ArrayList<Evidence>();
		newReport = new EvidenceReport(evidences, new Date());
	}
	
	@Test
	@DisplayName("Deve acessar página do selenium.org")
	public void deveAcessarPaginaSeleniumOrg(TestInfo info) {
		newReport.setScene(info.getDisplayName());
		try {
			evidences.add(new Evidence("Acessou página do selenium", true, screenshot(), new Date()));
		} catch (Exception any) {
			evidences.add(new Evidence(any.getMessage(), false, screenshot(), new Date()));
		}
	}
	
	@Test
	@DisplayName("Deve falhar ao acessar página do selenium.org Deve falhar ao acessar página do selenium.org")
	public void deveFalharAoAcessarPaginaSeleniumOrg(TestInfo info) {
		newReport.setScene(info.getDisplayName());
		try {
			evidences.add(new Evidence("Acessou página do selenium", true, screenshot(), new Date()));
		} catch (Exception any) {
			evidences.add(new Evidence(any.getMessage(), false, screenshot(), new Date()));
		}
	}
	
	@AfterEach
	public void tearDown() {
		GeneratorEvidenceReport.generate(newReport);
		evidences.clear();
		driver.quit();
	}

	private File screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}
	
}
