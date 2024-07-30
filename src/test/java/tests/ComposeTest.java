package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComposePage;
import pages.LoginPage;
import utils.PropertiesUtil;
import utils.ScreenshotUtil;

public class ComposeTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private ComposePage composePage;

	@BeforeMethod
	public void setUp() {
		try {
			driver = new ChromeDriver();
			driver.get(PropertiesUtil.get("url"));
			loginPage = new LoginPage(driver);
			composePage = new ComposePage(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Setup failed.");
		}
	}

	@Test
	public void testComposeEmail() {
		try {
			loginPage.login(PropertiesUtil.get("email"), PropertiesUtil.get("password"));
			composePage.composeEmail("kirupasankarkalimuthu@gmail.com", "Incubyte", "QA test for Incubyte");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Test compose email failed.");
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (driver != null) {
			try {
				if (!result.isSuccess()) {
					ScreenshotUtil.takeScreenshot(driver, "path/to/screenshot.png");
				}
				driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to close the browser.");
			}
		}
	}
}
