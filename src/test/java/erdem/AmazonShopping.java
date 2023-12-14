package erdem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonShopping {
    public static void main(String[] args) {
        // FirefoxDriver'ı başlat
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Amazon sitesine git
        driver.get("https://www.amazon.com");

        // Amazon giriş yapma işlemi
        loginToAmazon(driver, "kullanici_adi", "sifre");

        // Alışveriş sepetine ürün ekleme işlemi
        addToCart(driver, "kitap_adı");

        // Tarayıcıyı kapatma
        driver.quit();
    }

    private static void loginToAmazon(WebDriver driver, String username, String password) {
        // Giriş yapma sayfasına git
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys(username);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
    }

    private static void addToCart(WebDriver driver, String itemName) {
        // Arama çubuğuna ürün adını yaz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(itemName);
        searchBox.submit();

        // İlk ürünü sepete ekle
        WebElement addToCartButton = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCartButton.click();
    }
}
