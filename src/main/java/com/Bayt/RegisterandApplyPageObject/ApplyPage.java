package com.Bayt.RegisterandApplyPageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Bayt.ActionDriver.Action;
import com.Bayt.Base.Base;
import com.github.javafaker.Faker;

public class ApplyPage {

	public WebDriver driver;
	Action action = new Action();
	Faker faker = new Faker();

	public ApplyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/section[4]/div/div[1]/div[1]/div/div/a")
	private WebElement Clickjobs;

	@FindBy(xpath = "//a[@class='btn is-small']")
	private WebElement EasyAplly;

	@FindBy(xpath = "//input[@id='JsApplicantRegisterForm_firstName']")
	private WebElement FirstNameField;

	@FindBy(xpath = "//input[@id='JsApplicantRegisterForm_lastName']")
	private WebElement LastNameField;

	@FindBy(xpath = "//input[@id='JsApplicantRegisterForm_email']")
	private WebElement EmailaddressField;

	@FindBy(xpath = "//input[@id='JsApplicantRegisterForm_password']")
	private WebElement PasswordField;

	@FindBy(xpath = "//input[@id='mobPhoneAreaCode__r']")
	private WebElement MobPhoneAreaCode;

	@FindBy(xpath = "//*[@id=\"JsApplicantRegisterForm_mobPhone\"]")
	private WebElement PhoneNumberField;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/section[1]/form[1]/footer[1]")
	private WebElement ApplyNow;

	@FindBy(xpath = "//button[@id='register']")
	private WebElement CheekMassage;

	@FindBy(name = "personalInformationForm[birthDay]")
	private WebElement Day;

	@FindBy(css = "#personalInformationForm_birthMonth__r")
	private WebElement Month;

	@FindBy(name = "personalInformationForm[birthYear]")
	private WebElement Year;

	@FindBy(xpath = "//label[contains(text(),'Female')]")
	private WebElement Female;

	@FindBy(name = "personalInformationForm[nationalityCitizenAc]")
	private WebElement Yournationality;

	@FindBy(name = "v__personalInformationForm[resCountry]")
	private WebElement Residencecountry;

	@FindBy(name = "v__personalInformationForm[resCity]")
	private WebElement City;

	@FindBy(name = "v__personalInformationForm[visaStatus]")
	private WebElement VisaStatus;

	@FindBy(id = "experienceForm_hasExperience_0")
	private WebElement experience;

	@FindBy(xpath = "//*[@id=\"experienceForm_jobTitle\"]")
	private WebElement jobtitle;

	@FindBy(xpath = "//input[@id='experienceForm_jobRole__r']")
	private WebElement titlefallUnder;

	@FindBy(xpath = "//input[@id='experienceForm_country__r']")
	private WebElement Joblocation;

	@FindBy(id = "experienceForm_startMonth__r")
	private WebElement StartdateMo;

	@FindBy(name = "experienceForm[startYear]")
	private WebElement StartdateYe;

	@FindBy(xpath = "//*[@id=\"experienceDetails\"]/section/div[5]/div/label")
	private WebElement StillWorkHere;

	@FindBy(xpath = "//input[@id='experienceForm_company']")
	private WebElement CompanyName;

	@FindBy(xpath = "//input[@id='experienceForm_companyInd__r']")
	private WebElement CompanyIndustry;

	@FindBy(id = "EducationForm_degree")
	private WebElement Degree;

	@FindBy(xpath = "//input[@id='EducationForm_institution']")
	private WebElement University;

	@FindBy(xpath = "//input[@id='EducationForm_educationCountry__r']")
	private WebElement ChooseCountry;

	@FindBy(xpath = "//*[@id=\"EducationForm_educationCity__r\"]")
	private WebElement ChoosecCty;

	@FindBy(xpath = "//input[@id='EducationForm_major']")
	private WebElement Major;

	@FindBy(id = "EducationForm_completionYear")
	private WebElement GraduationYe;

	@FindBy(xpath = "//*[@id=\"EducationForm_completionMonth__r\"]")
	private WebElement GraduationMo;

	@FindBy(xpath = "//*[@id=\"targetJobForm_positionSought\"]")
	private WebElement JobTitle;

	@FindBy(xpath = "//*[@id=\"targetJobForm_careerLevel__r\"]")
	private WebElement JobLevel;

	@FindBy(xpath = "//*[@id=\"yw0\"]/footer/div/input")
	private WebElement SaveBuuton;

	public void Aplly() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		action.scrollByVisibilityOfElement(driver, Clickjobs);
		Thread.sleep(2000);
		Base.takeScreenshot(null, driver);
		action.click(driver, Clickjobs);
		Base.takeScreenshot(null, driver);
		action.click(driver, EasyAplly);
		driver.navigate().refresh();
		String firstName = faker.name().firstName();
		action.typestring(FirstNameField, firstName);
		String LirstName = faker.name().lastName();
		action.typestring(LastNameField, LirstName);
		String Emailaddress = firstName.toLowerCase() + LirstName.toLowerCase() + "@gmail.com";
		action.typestring(EmailaddressField, Emailaddress);
		String Password = faker.number().toString();
		action.typestring(PasswordField, Password);
		String PhoneNumber = "079" + faker.number().numberBetween(1000000, 2000000);
		action.typestring(PhoneNumberField, PhoneNumber);
		action.selectBySendkeys("Jordan", MobPhoneAreaCode);
		MobPhoneAreaCode.sendKeys(Keys.ENTER);
		action.click(driver, ApplyNow);
		Thread.sleep(3000);
		Base.takeScreenshot(null, driver);

	}

	public void TellUsAboutyourself() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.removeCSSStyle();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('personalInformationForm_birthDay').removeAttribute('style')");
		action.selectByIndex(Day, 1);
		Thread.sleep(2000);
		action.selectBySendkeys("January", Month);
		Month.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("document.getElementById('personalInformationForm_birthYear').removeAttribute('style')");
		action.selectByValue(Year, "1992");
		action.click(driver, Female);
		Thread.sleep(4000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript(
				"document.getElementById('personalInformationForm_nationalityCitizenAc').removeAttribute('style')");
		action.selectByIndex(Yournationality, 2);
		Thread.sleep(2000);
		action.selectBySendkeys("Citizen", VisaStatus);
		VisaStatus.sendKeys(Keys.ENTER);
	}

	public void Addexperience() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.removeCSSStyle();
		action.typestring(jobtitle, "Quality Assurance Engineer");
		Thread.sleep(3000);
		action.selectBySendkeys("Quality Control", titlefallUnder);
		titlefallUnder.sendKeys(Keys.ENTER);
		action.selectBySendkeys("Jordan", Joblocation);
		Joblocation.sendKeys(Keys.ENTER);
		action.selectBySendkeys("January", StartdateMo);
		StartdateMo.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		action.JSClick(driver, StillWorkHere);
		Thread.sleep(2000);
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("document.getElementById('experienceForm_startYear').removeAttribute('style')");
		action.selectByIndex(StartdateYe, 5);
		Thread.sleep(3000);
		action.typestring(CompanyName, "Bank");
		CompanyIndustry.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		action.selectBySendkeys("Banking", CompanyIndustry);
		CompanyIndustry.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void Addeducation(String chooseCountry, String choosecCty) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.removeCSSStyle();
		Thread.sleep(3000);
		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("document.getElementById('EducationForm_degree').removeAttribute('style')");
		action.selectByIndex(Degree, 2);
		Thread.sleep(3000);
		action.typestring(University, "Al-Hussein Bin Talal University");
		action.selectBySendkeys(chooseCountry, ChooseCountry);
		ChooseCountry.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		action.selectBySendkeys(choosecCty, ChoosecCty);
		ChoosecCty.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		action.typestring(Major, "computer");
		Thread.sleep(4000);
		action.selectBySendkeys("January", GraduationMo);
		GraduationMo.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("document.getElementById('EducationForm_completionYear').removeAttribute('style')");
		action.selectByValue(GraduationYe, "2020");
		Thread.sleep(3000);
	}

	public void YourPreFerredjob() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.removeCSSStyle();
		action.scrollByVisibilityOfElement(driver, JobTitle);
		Thread.sleep(3000);
		action.typestring(JobTitle, "Automation Testing");
		action.selectBySendkeys("Mid Career", JobLevel);
		JobLevel.sendKeys(Keys.ENTER);
		action.JSClick(driver, SaveBuuton);
		Base.takeScreenshot(null, driver);

	}

}
