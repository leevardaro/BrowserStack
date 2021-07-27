package browserStack;

//Sample test in Java to run Automate session.
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Homework {
public static final String AUTOMATE_USERNAME = "leevardaro_sqiF2Y";
public static final String AUTOMATE_ACCESS_KEY = "XNR17aPXPp6NaNZNvyD2";
public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
public static void main(String[] args) throws Exception {
 DesiredCapabilities caps = new DesiredCapabilities();
 caps.setCapability("browserName", "Chrome");
 caps.setCapability("browser_version", "latest");
 caps.setCapability("os", "Windows");
 caps.setCapability("os_version", "10");
 caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
 caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
 String baseUrl = "https://www.google.com";
 String expectedTitle = "Troy University | Troy University";
 String expectedDegree = "Computer Systems Engineer/Architect";
 String actualTitle = "";
 String degreeTitle = "";
 WebDriverWait wait = new WebDriverWait(driver, 10);
 // launch browser and direct it to the Base URL
 driver.manage().window().maximize();
 driver.get(baseUrl);
 
 WebElement googleSearch = driver.findElement(By.name("q"));
 googleSearch.sendKeys("Troy University");
 googleSearch.submit();
 
 //WebElement troy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href ='https://www.troy.edu/'")));

 WebElement troyLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href ='https://www.troy.edu/']")));
 troyLink.click();
 
 WebElement troySearch = driver.findElement(By.id("global-search--desktop"));
 troySearch.sendKeys("Computer Science Department");
 troySearch.submit();
 
 WebElement compDeptLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,\"Bachelor's Degree\")]/b[.=\"Computer\"]/..")));
 compDeptLink.click();

 WebElement compEngExpand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Computer Systems Engineer/Architect']")));
 compEngExpand.click();
 
  
 WebElement compEngLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='/career/index.html#15-1199.02']")));
 compEngLink.click();
 //WebElement compEngLink = driver.findElement(By.xpath("//*[@href='/career/index.html#15-1199.02']/.."));
 //compEngLink.click();
 // get the actual value of the title
 actualTitle = driver.getTitle();
 System.out.println(actualTitle);
 degreeTitle = driver.findElement(By.xpath("//*[@class='ccTitle']")).getText();
 System.out.println(degreeTitle);
 /*
  * compare the actual title of the page with the expected one and print
  * the result as "Passed" or "Failed"
  */
 if (actualTitle.contentEquals(expectedTitle)&&degreeTitle.contentEquals(expectedDegree)){
     System.out.println("Test Passed!");
 } else {
     System.out.println("Test Failed");
 }

 //close driver
 driver.quit();

}


// This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
public static void markTestStatus(String status, String reason, WebDriver driver) {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
}
} 
