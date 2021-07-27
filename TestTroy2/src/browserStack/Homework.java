package browserStack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Homework {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://www.google.com";
        String expectedTitle = "Troy University | Troy University";
        String expectedDegree = "Computer Systems Engineer/Architect";
        String actualTitle = "";
        String degreeTitle = "";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        
        WebElement googleSearch = driver.findElement(By.name("q"));
        googleSearch.sendKeys("Troy University");
        googleSearch.submit();
        
        //WebElement troy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href ='https://www.troy.edu/'")));
       
        WebElement troyLink = driver.findElement(By.xpath("//a[@href ='https://www.troy.edu/']"));
        troyLink.click();
        
        WebElement troySearch = driver.findElement(By.id("global-search--desktop"));
        troySearch.sendKeys("Computer Science Department");
        troySearch.submit();
        
        WebElement compDeptLink = driver.findElement(By.xpath("//a[contains(.,\"Bachelor's Degree\")]/b[.=\"Computer\"]/.."));
        compDeptLink.click();

        WebElement compEngExpand = driver.findElement(By.xpath("//*[@aria-label='Computer Systems Engineer/Architect']"));
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
       
        //close Fire fox
        //driver.close();
       
    }

}