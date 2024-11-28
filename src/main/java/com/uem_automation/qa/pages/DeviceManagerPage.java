package com.uem_automation.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.uem_automation.qa.utils.Utilities;

public class DeviceManagerPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.EXPLICIT_WAIT_TIME));

	// Objects
	@FindBy(xpath = "//img[@src='theme/dist/assets/media/logos/topMenu-Logo-X.png']")
	private WebElement logoTopMenu;

	@FindBy(xpath = "//img[@src='theme/dist/assets/media/logos/leftMenu-Logo-S.png']")
	private WebElement logoLeftMenu;

	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_MUIMainMenulblGrpInfrmtn']")
	private WebElement groupInformationTabElement;
	
	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_MUIMainMenulblWndwsOSPrfl']")
	private WebElement WindowsOsProfileTabElement;
	
	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_MUIMainMenulblLiOSPrfl']")
	private WebElement linuxOsProfileTabElement;

	@FindBy(xpath = "//*[@id='tblGroupListCard1']/tbody/tr/td[1]")
	private WebElement groupInformationElement;
	
	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_lblGrpSysSettng']")
	private WebElement windowsOsProfileInformationElement;
	
	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_lblSystemSettLinuxGroup']")
	private WebElement linuxOsProfileInformationElement;

	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_MUIMainMenulblGrpTMDM']")
	private WebElement TaskManagerTab;

	@FindBy(xpath = "//td[contains(@class,'linklbl')][normalize-space()='1']")
	private WebElement taskEntry;

	@FindBy(xpath = "//a[@id='kt_aside_toggle']")
	private WebElement rhsMenuToogle;

	@FindBy(xpath = "//h1[normalize-space()='Windows']")
	private WebElement windowsRHStoogle;

	@FindBy(xpath = "(//label[@title='System Settings'][normalize-space()='System Settings'])[4]")
	private WebElement windowsSystemSettingsDropdown;

	@FindBy(xpath = "(//label[@title='Time and Language'][normalize-space()='Time and Language'])[2]")
	private WebElement windowsSystemSettingsTimeAndLanguageDropdown;

	@FindBy(xpath = "(//label[@title='Date & Time'][normalize-space()='Date & Time'])[3]")
	private WebElement windowsSystemSettingsTimeAndLanguageDateAndTimeDropdown;

	@FindBy(xpath = "//div[@id='divWindowsDateTimeSettings']//label[2]//span[1]")
	private WebElement executeLaterRadioButton;

	@FindBy(xpath = "//input[@id='XPDatetimeSett_btnApplyDateTimeSetup' and @value='Save']")
	private WebElement btnSaveDateTimeSetup;

	@FindBy(xpath = "//div[@id='divIAgree']//label[@class='checkbox']//span")
	private WebElement iAgreeCheckbox;

	@FindBy(xpath = "//input[@id='btnOKConfirmationPopup']")
	private WebElement okConfirmationButtonPopup;

	@FindBy(xpath = "//label[@id='XPDatetimeSett_lblMSg_Success']")
	private WebElement dateTimeSettLblMsgSuccess;

	@FindBy(xpath = "//a[@href='https://www.sundynetech.com/']")
	private WebElement companyWebsiteUrlFooter;

	@FindBy(xpath = "//a[@class='icon-lg text-dark ki ki-close mr-1 ml-1 fa-1x closeGroupInfo CloseNew']")
	private WebElement closeGroupInfo;
	
	@FindBy(xpath = "//div[contains(@class,'rtSelected')]//span[contains(@class,'rtPlus')]")
	private WebElement expandSelectedGroupIconElement;
	
	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_lblsysteminformation']")
	private WebElement systemInformationTabElement;
	
	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_lblsystemprofile']")
	private WebElement systemProfileTabElement;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblOSNameSysDetailsCE']")
	private WebElement systemDetailsElement;
	
	@FindBy(xpath = "//label[@id='ContentPlaceHolder1_lblSystemSettWinNode']")
	private WebElement systemSettingsWindowsNodeElement;
	
	// constructor
	public DeviceManagerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean isLogoDisplayed(String companyWebsiteUrlproperty) {
		waitTillFooterCompanyWebsiteURLIsDisplayed(companyWebsiteUrlproperty);
		if (logoTopMenu.isDisplayed()) {
//			wait.until(ExpectedConditions.visibilityOf(logoTopMenu));
			return true;
		} else if (logoLeftMenu.isDisplayed()) {
//			wait.until(ExpectedConditions.visibilityOf(logoLeftMenu));
			return true;
		} else {
			return false;
		}
	}

	public void clickOnTheGroup(String groupNameProperty) {
		WebElement grp = driver.findElement(By.xpath("//span[contains(text(), '" + groupNameProperty + " (')]"));
		wait.until(ExpectedConditions.elementToBeClickable(grp));
		grp.click();
	}

	public void clickOnTheGroupInformationTab() {
		wait.until(ExpectedConditions.elementToBeClickable(groupInformationTabElement));
		groupInformationTabElement.click();
	}

	public void clickOnRHSMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogle));
		rhsMenuToogle.click();
	}

	public void clickOnWindowsRHS() {
		windowsRHStoogle.click();
	}

	public void clickOnWindowsSystemSettingRHS() {
		windowsSystemSettingsDropdown.click();
	}

	public void clickOnWindowsSystemSettingTimeAndLanguageRHS() {
		windowsSystemSettingsTimeAndLanguageDropdown.click();
	}

	public void clickOnWindowsSystemSettingTimeAndLanguageDateAndTimeRHS() {
		windowsSystemSettingsTimeAndLanguageDateAndTimeDropdown.click();
	}

	public void waitTillFooterCompanyWebsiteURLIsDisplayed(String companyWebsiteUrlProperty) {
		wait.until(ExpectedConditions.visibilityOf(companyWebsiteUrlFooter));
		wait.until(ExpectedConditions.elementToBeClickable(companyWebsiteUrlFooter));
		Assert.assertEquals(companyWebsiteUrlFooter.getText(), companyWebsiteUrlProperty,
				"[Error: Footer element Company website url is not displyed or clickable]") ;
	}

	public String retrieveGroupInformation() {
		return groupInformationElement.getText();
	}

	public void selectExecuteLaterRadioButton() {
		executeLaterRadioButton.click();
	}

	public void clickOnSave() {
		wait.until(ExpectedConditions.visibilityOf(btnSaveDateTimeSetup));
		wait.until(ExpectedConditions.elementToBeClickable(btnSaveDateTimeSetup));
		btnSaveDateTimeSetup.click();
	}

	public void checkIagreeCheckboxAndClickOnOkButton() {
		wait.until(ExpectedConditions.elementToBeClickable(iAgreeCheckbox));
		iAgreeCheckbox.click();
		okConfirmationButtonPopup.click();
	}

	public String retrieveTheResponceMessageLabel() {
		wait.until(ExpectedConditions.visibilityOf(dateTimeSettLblMsgSuccess));
		return dateTimeSettLblMsgSuccess.getText();
	}

	public void clickOnTheTaskManagerTab() {
		TaskManagerTab.click();
	}

	public boolean isTaskEntryDisplayed() {
		return taskEntry.isDisplayed();
	}

	public void clickOnTheWindowsOsProfileTab() {
		wait.until(ExpectedConditions.elementToBeClickable(WindowsOsProfileTabElement));
		WindowsOsProfileTabElement.click();
	}
	
	public void clickOnTheLinuxOsProfileTab() {
		wait.until(ExpectedConditions.elementToBeClickable(linuxOsProfileTabElement));
		linuxOsProfileTabElement.click();
	}

	public String retrieveWindowsOsProfileInformation() {
		return windowsOsProfileInformationElement.getText(); // SYSTEM SETTINGS
	}

	public String retrieveLinuxOsProfileInformation() {
		return linuxOsProfileInformationElement.getText(); // SYSTEM SETTINGS
	}

	public void selectTheDevice(String deviceIpProperty) {
		WebElement deviceIpChkboxElement = driver.findElement(By.xpath("//td[normalize-space()='" + deviceIpProperty + "']/parent::tr/td/div[@class='checkbox']"));
		deviceIpChkboxElement.click();
	}

	public void expandTheGroupSelected() {
		expandSelectedGroupIconElement.click();
	}

	public void clickOnTheDevice(String deviceIpProperty) {
		WebElement deviceIpElement = driver.findElement(By.xpath("//span[normalize-space()='" + deviceIpProperty + "']"));
		deviceIpElement.click();
	}

	public void clickOnSystemInformationTab() {
		systemInformationTabElement.click();
	}

	public String retrieveSystemInformation() {
		return systemDetailsElement.getText();
	}

	public void clickOnSystemProfileTab() {
		systemProfileTabElement.click();
		
	}

	public boolean isSystemSettingsWindowsNodeDisplayed() {
		return systemSettingsWindowsNodeElement.isDisplayed();
	}

}
