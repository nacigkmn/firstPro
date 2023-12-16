package erdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class LogMedimops {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nacig\\Desktop\\web\\prosject\\firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        loginToMedimops(driver, "************", "*****");
        //driver.get("https://www.medimops.de/MeinMerkzettel/");
        //acceptCookies(driver);
        wait(2000);
        clearBrowserCache(driver);
        addFavBooksToCart(driver);
       // addToCart(driver);
        //getAvaibleBook(driver);
    }


    public static void clearBrowserCache(WebDriver webDriver) {
        webDriver.manage().deleteAllCookies();

        wait(2000);
    }

    private static void loginToMedimops(WebDriver driver, String username, String password) {
        // Giriş yapma sayfasına git

        driver.get("https://www.medimops.de/Mein-Konto/");
        clearBrowserCache(driver);
        acceptCookies(driver);

        WebElement button_username = driver.findElement(By.id("lgn_usr"));
        button_username.sendKeys(username);
        wait(3000);
        WebElement button_password = driver.findElement(By.id("password"));
        button_password.sendKeys(password);
        wait(3000);

        driver.findElement(By.cssSelector(".login-form__submit.btn.btn--primary.btn--fluid")).submit();
    }

    private static void addFavBooksToCart(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonToFavBooks = driver.findElement(By.cssSelector("a.dashboard__button-cta.dashboard__button-cta--list"));
        buttonToFavBooks.click();

        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//a[contains(text(), 'In den Warenkorb')]"));
        for (WebElement addToCartButton : addToCartButtons) {
            addToCartButton.click();
            System.out.println(addToCartButton.getAttribute("class")+"sepete eklendi.");
        }

    }

    private  static  void getAvaibleBook(WebDriver driver){

        List<WebElement> elements = driver.findElements(By.className("notice-list-product__grid "));
        elements.forEach(x-> System.out.println(x));
    }





    private static void addToCart(WebDriver driver) {
        // Tüm "a" elementlerini bul
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("a.add-to-cart.add-to-cart__main"));

        // Her bir "a" elementine tıkla
        for (WebElement addToCartButton : addToCartButtons) {
            // Bağlantının metnini kontrol et
            if (addToCartButton.getText().contains("In den Warenkorb")) {
                addToCartButton.click();
                System.out.println("Ürün sepete eklendi.");

            }
        }
    }




    public static void acceptCookies(WebDriver driver) {
        WebElement button = driver.findElement(By.id("accept-all"));
        button.click();
        wait(3000);

    }

    private static void acceptCokies(WebDriver driver) {
        WebElement button = driver.findElement(By.id("accept-all"));
        button.click();
        wait(3000);

    }



    private static void wait(int interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            System.out.println("Error in waiting");
            throw new RuntimeException(e);
        }

    }


}
