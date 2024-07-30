package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ComposePage {
	private WebDriver driver;

	private By composeButton = By.cssSelector(".T-I.T-I-KE.L3");
	private By toField = By.name("to");
	private By subjectField = By.name("subjectbox");
	private By bodyField = By.cssSelector(".Am.Al.editable.LW-avf");
	private By sendButton = By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3");

	public ComposePage(WebDriver driver) {
		this.driver = driver;
	}

	public void composeEmail(String to, String subject, String body) {
		try {
			driver.findElement(composeButton).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(toField).sendKeys(to);
			driver.findElement(subjectField).sendKeys(subject);
			driver.findElement(bodyField).sendKeys(body);
			driver.findElement(sendButton).click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to compose email.");
		}
	}
}
