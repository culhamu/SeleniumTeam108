package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_MavenIlkClass {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        // 2- arama kutusunu locate edelim
        WebElement searcBox=driver.findElement(By.id("twotabsearchtextbox"));
        // 3- “Samsung headphones” ile arama yapalim
        searcBox.sendKeys("Samsung headphones"+ Keys.ENTER);
        // 4- Bulunan sonuc sayisini yazdiralim
        System.out.println(driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText());
        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        // 6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();

        List<WebElement> basliklar=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        int elementNo=1;
        for (WebElement each:basliklar) {

            System.out.println(elementNo+"-->"+each.getText());
            elementNo++;
        }
        driver.close();
    }
}
