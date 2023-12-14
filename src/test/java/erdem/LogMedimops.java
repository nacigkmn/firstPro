package erdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogMedimops {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nacig\\Desktop\\web\\prosject\\firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        loginToMedimops(driver,"naci2575@gmail.com","naci@1234");
        System.out.println("hello world");

    }


    public static void clearBrowserCache(WebDriver webDriver) throws InterruptedException {
        webDriver.manage().deleteAllCookies();
        Thread.sleep(3000);
        //wait(3000);
    }

    private static void loginToMedimops(WebDriver driver, String username, String password) throws InterruptedException {
        // Giriş yapma sayfasına git

        driver.get("https://www.medimops.de/Mein-Konto/");
        clearBrowserCache(driver);
        acceptCookies(driver);

       WebElement button_username = driver.findElement(By.id("lgn_usr"));
       button_username.sendKeys(username);
        Thread.sleep(3000);
       WebElement button_password = driver.findElement(By.id("password"));
       button_password.sendKeys(password);
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".login-form__submit.btn.btn--primary.btn--fluid")).submit();


    }


    public static void acceptCookies(WebDriver driver) throws InterruptedException {
        WebElement button = driver.findElement(By.id("accept-all"));
        button.click();
        Thread.sleep(1000);
        // wait(1000);
    }

    private static void acceptCokies(WebDriver driver) throws InterruptedException {
        WebElement button = driver.findElement(By.id("accept-all"));
        button.click();
        Thread.sleep(1000);
       // wait(1000);
    }


    public static void clearBrowsercache(WebDriver webDriver) throws InterruptedException {
        webDriver.manage().deleteAllCookies();
        Thread.sleep(1000);
       // wait(3000);

    }


    public static void wait(int interval) {

    }


}
