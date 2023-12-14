package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestClass {

    public static void main(String[] args) throws InterruptedException {
   System.setProperty("webdriver.chrome.driver","C:\\Users\\nacig\\Desktop\\web\\prosject\\chrome\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.get("https:\\www.amazon.com");

        System.out.println("Cuurent Url: "+ driver.getCurrentUrl());
        System.out.println(""+ driver.getTitle());

        Thread.sleep(3000);
        driver.close();
    }
}
