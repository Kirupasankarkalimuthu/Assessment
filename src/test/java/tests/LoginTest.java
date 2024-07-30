package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertiesUtil;

public class LoginTest {
	private WebDriver driver;
	private LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		try {
			driver = new ChromeDriver();
			driver.get(PropertiesUtil.get("url"));
			loginPage = new LoginPage(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Setup failed.");
		}
	}

	@Test
	public void testLogin() {
		try {
			loginPage.login(PropertiesUtil.get("email"), PropertiesUtil.get("password"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Test login failed.");
		}
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to close the browser.");
			}
		}
	}
}
