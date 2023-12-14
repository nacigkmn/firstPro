package lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\nacig\\Desktop\\web\\prosject\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.amazon.com");
        System.out.println("Cuurent Url: "+ driver.getCurrentUrl());
        System.out.println(""+ driver.getTitle());
    }
}
