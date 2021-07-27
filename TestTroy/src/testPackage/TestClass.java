package testPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;



public class TestClass {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://jobs.workable.com/";
        String expectedTitle = "Job Search - Job Finder - Job Listings | Workable for Job Seekers";
        String expApplyTitle = "Customer Engineer- San Francisco - BrowserStack";

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        WebElement jobSearch = driver.findElement(By.xpath("//*[@data-ui=\'search-input\']"));
        jobSearch.sendKeys("browserstack customer experience engineer");
        WebElement locSearch = driver.findElement(By.xpath("//*[@data-ui=\'location-input\']"));
        locSearch.sendKeys("San Francisco");
        locSearch.submit();
        WebElement declineLink = driver.findElement(By.xpath("//*[@id='hs-eu-decline-button']"));
        declineLink.click();
      
        WebElement jobLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[.='Customer Engineer- San Francisco']/..//a[@data-ui='job-view']")));
        jobLink.click();
      
        WebElement applyLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='Apply for this job']")));
        applyLink.click();
        
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        String actApplyTitle = driver.getTitle();
        System.out.println(actApplyTitle);
        Assert.assertEquals(expApplyTitle, actApplyTitle);
    }
}

