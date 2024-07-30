package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("identifierId");
    private By nextButton = By.id("identifierNext");
    private By passwordField = By.name("password");
    private By passwordNextButton = By.id("passwordNext");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        try {
            driver.findElement(emailField).sendKeys(email);
            driver.findElement(nextButton).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(passwordNextButton).click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Login failed.");
        }
    }
}
