package com.uem_automation.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.uem_automation.qa.utils.Utilities;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.EXPLICIT_WAIT_TIME));

	// Objects
	@FindBy(xpath = "//input[contains(@placeholder, 'Please Enter Username')]")
	private WebElement usernameTextbox;

	@FindBy(xpath = "//input[contains(@placeholder, 'Please Enter Password')]")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='btnLogin']")
	private WebElement loginButton;

	@FindBy(xpath = "//label[@id='lblFailureText']")
	private WebElement actualFailureTextMessageElement;

	@FindBy(xpath = "//div[@id='spnForgotPass']")
	private WebElement forgotPasswordLinkElement;

	@FindBy(xpath = "//label[@id='lblRecoveryPassword']")
	private WebElement recoveryPasswordLabelElement;

	@FindBy(xpath = "//input[contains(@placeholder, 'Please Enter Username')]")
	private WebElement usernamePlaceholder;

	@FindBy(xpath = "//input[contains(@placeholder, 'Please Enter Password')]")
	private WebElement passwordPlaceholder;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void enterUsername(String username) {
		usernameTextbox.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void clickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
	}

	public String retrieveFailureTextMessage() {
		wait.until(ExpectedConditions.visibilityOf(actualFailureTextMessageElement));
		return actualFailureTextMessageElement.getText();
	}

	public boolean isPlaceholderTextDisplayedForUsernameAndPassword() {
		if (usernameTextbox.isDisplayed() && passwordTextbox.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void clickOnForgotPasswordLink() {
		wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLinkElement));
		forgotPasswordLinkElement.click();
	}

	public String retrieveLabelText() {
		wait.until(ExpectedConditions.visibilityOf(recoveryPasswordLabelElement));
		return recoveryPasswordLabelElement.getText();
	}

}
