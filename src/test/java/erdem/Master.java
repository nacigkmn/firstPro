package erdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Master {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nacig\\Desktop\\web\\prosject\\firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.medimops.de/Mein-Konto/");

        clearBrowserCache(driver);
        acceptCookies(driver);


        loginToAmazon(driver,"naci2575@gmail.com","naci@1234");

        searchProduct(driver,"Shark AV2501AE AI Robot Vacuum with XL HEPA Self-Empty Base, Bagless," +
                " 60-Day Capacity, LIDAR Navigation, Perfect for Pet Hair, Compatible with Alexa, Wi-Fi Connected, " +
                "Carpet & Hard Floor, Black");
        addProductToCart(driver,"Shark AV2501AE AI Robot Vacuum with XL HEPA Self-Empty Base, Bagless," +
                " 60-Day Capacity, LIDAR Navigation, Perfect for Pet Hair, Compatible with Alexa, Wi-Fi Connected, " +
                "Carpet & Hard Floor, Black");
        //printCartContents(driver);

    }

    private static void loginToAmazon(WebDriver driver, String username, String password) {
        // Giriş yapma sayfasına git
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys(username);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
    }

    public static void clearBrowserCache(WebDriver webDriver) throws InterruptedException {
        webDriver.manage().deleteAllCookies();
        Thread.sleep(3000);
        //wait(3000);
    }

    public static void acceptCookies(WebDriver driver) throws InterruptedException {
        WebElement button = driver.findElement(By.id("accept-all"));
        button.click();
        Thread.sleep(3000);
       // wait(1000);
    }

        private static void searchProduct(WebDriver driver, String productName) {
            // Arama kutusunu bul ve ürün adını gönder
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys(productName);

            // Arama düğmesine tıkla
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();
        }
    /*
        private static void addProductToCart(WebDriver driver, String productName) throws InterruptedException {

            WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(text(), '" + productName + "')]/ancestor::div[@id='add-to-cart']//button"));
            addToCartButton.click();


            WebElement proceedToCheckoutButton = driver.findElement(By.id("proceed-to-checkout-button"));
            proceedToCheckoutButton.click();
            Thread.sleep(3000);
        }
    */
    private static void printCartContents(WebDriver driver) {
        // Sepet içeriğini bulmak için uygun CSS veya XPath kullanın
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart-item")); // Örnek bir CSS seçici, gerçek CSS'i kontrol etmelisiniz

        // Sepetteki her ürün için adını yazdırın
        for (WebElement cartItem : cartItems) {
            String productName = cartItem.findElement(By.cssSelector(".product-name")).getText(); // Örnek bir CSS seçici, gerçek CSS'i kontrol etmelisiniz
            System.out.println("Sepetteki Ürün: " + productName);
        }
    }

    private static void addProductToCart(WebDriver driver, String productName) throws InterruptedException {
        WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(text(), '" + productName + "')]/ancestor::div[@id='add-to-cart']//button"));
        addToCartButton.click();

        // Bekleme ekleyebilirsiniz
        Thread.sleep(3000);

        WebElement proceedToCheckoutButton = driver.findElement(By.id("proceed-to-checkout-button"));
        proceedToCheckoutButton.click();
        printCartContents(driver);
        Thread.sleep(3000);
    }


}
