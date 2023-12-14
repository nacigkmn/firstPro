package erdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonPurchase {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nacig\\Desktop\\web\\prosject\\firefox\\geckodriver");


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        System.out.println("hello world");

        // Amazon'un çerezleri kabul etme işlemi
        acceptCookies(driver);

        // Amazon'a giriş yapma işlemi (Sizin giriş bilgilerinizle güncellenmeli)
        loginToAmazon(driver, "kullanici_adi", "sifre");

        // Satın almak istediğiniz ürünü arama ve sepete ekleme işlemi
        searchAndAddToCart(driver, "kitap_adı");

        // Sepeti görüntüleme ve satın alma işlemi
        viewCartAndCheckout(driver);

        // Tarayıcıyı kapatma
        driver.quit();
    }

    private static void acceptCookies(WebDriver driver) {
        try {
            WebElement acceptButton = driver.findElement(By.id("sp-cc-accept"));
            acceptButton.click();
        } catch (Exception e) {
            // Çerez kabul düğmesi bulunamazsa bu hatayı görmezden gel
        }
    }

    private static void loginToAmazon(WebDriver driver, String username, String password) {
        // Sizin giriş bilgilerinizi kullanarak Amazon'a giriş yapma işlemi
        // Bu kısım oturum açma sayfasına yönlendiren bir dizi işlem içermelidir.
    }

    private static void searchAndAddToCart(WebDriver driver, String itemName) {
        // Arama çubuğuna ürün adını yazma işlemi
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(itemName);
        searchBox.submit();

        // İlk ürünü sepete ekleme işlemi (Bu adım spesifik olarak belirlenmelidir)
        WebElement addToCartButton = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCartButton.click();
    }

    private static void viewCartAndCheckout(WebDriver driver) {
        // Sepeti görüntüleme işlemi
        WebElement cartIcon = driver.findElement(By.id("nav-cart-count-container"));
        cartIcon.click();

        // Sepeti kontrol etme ve ödeme işlemi
        // Bu kısım spesifik olarak belirlenmelidir ve ödeme adımları içermelidir.
    }
}
