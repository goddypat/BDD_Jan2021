package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {


WebDriver driver;
 public Login(WebDriver driver) {
  this.driver = driver; 
 }
 // Element library
 @FindBy(how = How.XPATH, using = "//input[@id='username']")
 WebElement User_Name;
 @FindBy(how = How.XPATH, using = "//input[@id='password']")
 WebElement Password;
 @FindBy(how = How.XPATH, using = "//button[@name='login']")
 WebElement SignIn;

// Interactive method
 public void enterUserName(String userName) {
  User_Name.sendKeys(userName);
 }
 public void enterPassword(String password) {
  Password.sendKeys(password);
 }
 public void enterCredentials(String userName, String password) {
  User_Name.sendKeys(userName);
  Password.sendKeys(password);
 }
 public void clickOnSignInButton() {
  SignIn.click();
 }
 public String getPageTitle() {
  return driver.getTitle();
 }

 public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
	  TakesScreenshot ts = ((TakesScreenshot)driver);
	  File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	  SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
	  Date date = new Date();
	  String label = formatter.format(date);
	  String currentDirectory = System.getProperty("user.dir");
	  FileUtils.copyFile(sourceFile, new File(currentDirectory + "/screenshot/" + label +".png"));


}
}
