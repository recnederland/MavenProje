package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day08_proje_02 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Before
    public  void baslngic(){
        driver.get("https://google.com");
    }
    @After
    public void bitis(){
    }
    @Test
    public void test1()  {

        WebElement gogleArama=driver.findElement(By.name("q"));
        gogleArama.sendKeys("ebay");
        gogleArama.submit();

        WebElement aramaSonuc= driver.findElement(By.id("result-stats"));
        System.out.println(aramaSonuc.getText());

        WebElement ebayS_Bulma= driver.findElement(By.xpath("//h3"));
        ebayS_Bulma.click();

        WebElement urunBUlma= driver.findElement(By.id("gh-ac"));
        urunBUlma.sendKeys("electronics");
        urunBUlma.submit();

        WebElement ilkFiyat= driver.findElement(By.xpath("//*[@class='x-textrange__input x-textrange__input--from']"));
        ilkFiyat.sendKeys("300");

        WebElement sonFiyat= driver.findElement(By.xpath("//*[@class='x-textrange__input x-textrange__input--to']"));
        sonFiyat.sendKeys("700");

        WebElement markaSecme= driver.findElement(By.xpath("//*[@class='cbx x-refine__multi-select-cbx']"));
        markaSecme.click();

        List<WebElement> listem = driver.findElements(By.xpath("//h3[@class='s-item__title']"));

        for (WebElement w : listem){
            System.out.println(w.getText());
        }
    }
    @Test
    public void test2()  {
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("youtube");
        aramaKutusu.submit();

        WebElement youTubeSubmit= driver.findElement(By.xpath("//h3"));
        youTubeSubmit.click();

        WebElement arama= driver.findElement(By.name("search_query"));
        arama.sendKeys("fenerbahce galatasaray  1-3");
        arama.submit();

        // WebElement macOzeti= driver.findElement(By.xpath("//*[class='style-scope ytd-video-renderer']"));
        WebElement macOzeti= driver.findElement(By.id("video-title"));
        macOzeti.click();

        try {
            Thread.sleep(110000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://youtube.com");
        WebElement arama2= driver.findElement(By.name("search_query"));
        arama2.sendKeys("fener ağlama sneijder");
        arama2.submit();

        WebElement sonuc= driver.findElement(By.id("video-title"));
        sonuc .click();

        try {
            Thread.sleep(45000 );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}