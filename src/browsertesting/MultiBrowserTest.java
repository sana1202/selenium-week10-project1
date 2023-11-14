package browsertesting;
/*
BaseUrl = https://demo.nopcommerce.com/
1. Setup Chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Navigate to Url.
“https://demo.nopcommerce.com/login?returnUrl=
%2F”
7. Print the current url.
8. Navigate back to the home page.
9. Navigate to the login page.
10. Print the current url.
11. Refresh the page.
12. Enter the email to email field.
13. Enter the password to password field.
14. Click on Login Button.
15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MultiBrowserTest {
    //responsible to open the Url in the Browser
    static String baseUrl = "https://demo.nopcommerce.com/"; //BaseUrl = https://demo.nopcommerce.com/
    static String browser = "Chrome";
//    static String browser = "Firefox";
//    static String browser = "Edge";
//    static String browser = "Safari";
    public static void main(String[] args) throws InterruptedException {

        //1. Setup Chrome browser
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();//1. Setup Firefox browser
        //WebDriver driver = new EdgeDriver();//1. Setup Edge browser
       // WebDriver driver = new SafariDriver();//1. Setup Safari browser

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");//Selenium will use the ChromeWebDriver executable to control Chrome browser instances when you run your scripts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//An implicit wait tells Selenium to wait for a certain amount of time before throwing an exception when trying to find an element on a web page
        driver.manage().window().maximize();//This will maximize the browser

        //2. Open URL
        driver.get(baseUrl);

        //3. Print the title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is :"+ title);

        //4. Print the current url
        System.out.println("The current Url: "+ driver.getCurrentUrl());

        //5. Print the page source
        String pageSource = driver.getPageSource();
        System.out.println(driver.getPageSource());
        Thread.sleep(5000);

        /*
        6. Navigate to Url “https://demo.nopcommerce.com/login?returnUrl=%2F”
         */
        String newUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(newUrl);

        //7. Print the current url
        System.out.println("The current Url: "+ driver.getCurrentUrl());

        //8. Navigate back to the home page
        driver.navigate().to(baseUrl);

        //9. Navigate to the login page
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);

        //10. Print the current url
        System.out.println("The current Url: "+ driver.getCurrentUrl());

        //11. Refresh the page
        driver.navigate().refresh();

        //12. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("abc123@gmail.com");

        //13. Enter the password to password field
        WebElement passField = driver.findElement(By.id("Password"));
        passField.sendKeys("Confidential");

        //14. Click on Login Button.
        WebElement loginLink = driver.findElement(By.linkText("Log in"));

        //15. Close the browser
        driver.quit();
    }
}
