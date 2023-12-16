package erdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Master {
    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nacig\\Desktop\\web\\prosject\\firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        loginToMedimops(driver, "naci2575@gmail.com", "naci@1234");
        System.out.println("hello world");
    }

    public static void clearBrowserCache(WebDriver webDriver) {
        webDriver.manage().deleteAllCookies();
        wait(3000);

    }

    private static void loginToMedimops(WebDriver driver, String username, String password) {


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


    public static void acceptCookies(WebDriver driver)  {
        WebElement button = driver.findElement(By.id("accept-all"));
        button.click();
        wait(3000);

    }

    private static void acceptCokies(WebDriver driver) {
        WebElement button = driver.findElement(By.id("accept-all"));
        button.click();
        wait(3000);

    }


    public static void clearBrowsercache(WebDriver webDriver)  {
        webDriver.manage().deleteAllCookies();
        wait(3000);

    }



    private static void searchAddProductToCart(WebDriver driver, String productName)  {

        WebElement searchBox = driver.findElement(By.id("search__text-field"));
        searchBox.sendKeys(productName);

        // Arama düğmesine tıkla
        WebElement searchButton = driver.findElement(By.cssSelector(".search__submit"));
        searchButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(text(), '" + productName + "')]/ancestor::div[@id='add-to-cart']//button"));
        addToCartButton.click();

        // Bekleme ekleyebilirsiniz
        wait(3000);

        WebElement proceedToCheckoutButton = driver.findElement(By.id("proceed-to-checkout-button"));
        proceedToCheckoutButton.click();
        printCartContents(driver);
      wait(3000);
    }

    private static void printCartContents(WebDriver driver) {
        // Sepet içeriğini bulmak için uygun CSS veya XPath kullanın
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart-item")); // Örnek bir CSS seçici, gerçek CSS'i kontrol etmelisiniz

        // Sepetteki her ürün için adını yazdırın
        for (WebElement cartItem : cartItems) {
            String productName = cartItem.findElement(By.cssSelector(".product-name")).getText(); // Örnek bir CSS seçici, gerçek CSS'i kontrol etmelisiniz
            System.out.println("Sepetteki Ürün: " + productName);
        }
    }

    private  static void wait(int interval){
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            System.out.println("Error in waiting");
            throw new RuntimeException(e);
        }

    }


}
