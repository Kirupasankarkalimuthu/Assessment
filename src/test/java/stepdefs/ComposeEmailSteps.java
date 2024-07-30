package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ComposePage;
import pages.LoginPage;
import utils.PropertiesUtil;
import utils.ScreenshotUtil;

public class ComposeEmailSteps {
	private WebDriver driver;
	private LoginPage loginPage;
	private ComposePage composePage;

	@Given("the user is logged into Gmail")
	public void userIsLoggedIn() {
		try {
			driver = new ChromeDriver();
			driver.get(PropertiesUtil.get("url"));
			loginPage = new LoginPage(driver);
			composePage = new ComposePage(driver);
			loginPage.login(PropertiesUtil.get("email"), PropertiesUtil.get("password"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Setup failed.");
		}
	}

	@When("the user composes an email with subject {string} and body {string}")
	public void composeEmail(String subject, String body) {
		try {
			composePage.composeEmail("recipient@example.com", subject, body);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to compose email.");
		}
	}

	@When("the user composes an email without a subject")
	public void composeEmailWithoutSubject() {
		try {
			composePage.composeEmail("recipient@example.com", "", "QA test for Incubyte");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to compose email without subject.");
		}
	}

	@When("the user composes an email without a body")
	public void composeEmailWithoutBody() {
		try {
			composePage.composeEmail("recipient@example.com", "Incubyte", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to compose email without body.");
		}
	}

	@Then("the email should be sent successfully")
	public void emailShouldBeSentSuccessfully() {
		System.out.println("The Email should be sent successfully");
	}

	@Then("the email should not be sent")
	public void emailShouldNotBeSent() {
		System.out.println("The Email should not be sent");
	}

	@Then("an error message should be displayed")
	public void errorMessageShouldBeDisplayed() {
		System.out.println("An error message should be displayed");
	}

	@After
	public void tearDown(Scenario scenario) {
		if (driver != null) {
			try {
				if (scenario.isFailed()) {
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
