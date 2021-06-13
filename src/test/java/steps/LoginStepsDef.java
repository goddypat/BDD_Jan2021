package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.Login;
import util.BrowserFactory;

public class LoginStepsDef {

	WebDriver driver;
	Login loginPage;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.startBrowser();
		loginPage = PageFactory.initElements(driver, Login.class);
	}

	@Given("^User is on the Techfios login page$")
	public void User_is_on_the_techfios_login_page() {
		driver.get("http://www.techfios.com/billing/?ng=admin/");
	}

	@Given("^User is on the \"([^\"]*)\" login page$")
	public void user_is_on_the_login_page(String page) throws InterruptedException {
		if (page.equalsIgnoreCase("Techfios")) {
			driver.get("http://www.techfios.com/billing/?ng=admin/");
		} else if (page.equalsIgnoreCase("GoogleSearch")) {
			driver.get("https://www.google.com");
		}
		Thread.sleep(3000);
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) throws Throwable {
		loginPage.enterUserName(username);
		Thread.sleep(2000);
	}

// When User enters "<username>" and "<password>"
	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) throws InterruptedException {
		loginPage.enterPassword(password);
		Thread.sleep(2000);
	}

	@When("^User clicks on Signln button$")
	public void user_clicks_on_Signln_button() throws Throwable {
		loginPage.clickOnSignInButton();
		Thread.sleep(2000);
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page() throws Throwable {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		loginPage.takeScreenshotAtEndOfTest(driver);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
