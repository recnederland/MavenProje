package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SinifCalismasi02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https:\\www.ebay.com");

        //<input type="text" class="gh-tb ui-autocomplete-input" size="50" maxlength="300"
        // aria-label="Search for anything" placeholder="Search for anything"
        // id="gh-ac" name="_nkw" autocapitalize="off" autocorrect="off" spellcheck="false"
        // autocomplete="off" aria-haspopup="true" role="combobox" aria-owns="ui-id-1">

        WebElement aramaKutusu = driver.findElement(By.id("gh-ac"));

        aramaKutusu.sendKeys("mineral water bottle" + Keys.ENTER);

        // <input data-marko="{&quot;onblur&quot;:&quot;onBlurMin s0-13-11-0-1-2-6-0-6[3]-0-
        // textrange false&quot;,&quot;onkeyup&quot;:&quot;onKeyUp s0-13-11-0-1-2-6-0-6[3]-0-textrange
        // false&quot;}" pattern="\d*" type="text" size="6" maxlength="13"
        // aria-label="Minimum Value in $" class="x-textrange__input x-textrange__input--from" value=""
        // autocomplete="off" aria-invalid="false">
        // class="x-textrange__input x-textrange__input--from"

        // <div>Under $30.00<span class="clipped"> - apply Price filter</span><svg class="icon
        // icon--clear-small" focusable="false" aria-labelledby="s0-13-11-6-3-query_answer1-answer-2-1-0-8[0]-6[0]-0-0-2-1-5-text"
        // to-json="function noop() {}" aria-hidden="true"><use xlink:href="#icon-clear-small"></use></svg></div>

        WebElement ilkFiyatKutusu = driver.findElement(By.xpath("//input[@class=`x-textrange__input x-textrange__input--from`]"));
        ilkFiyatKutusu.sendKeys("5");

        // <input data-marko="{&quot;onblur&quot;:&quot;onBlurMax s0-13-11-0-1-2-6-0-6[3]-0-textrange
        // false&quot;,&quot;onkeyup&quot;:&quot;onKeyUp s0-13-11-0-1-2-6-0-6[3]-0-textrange false&quot;}"
        // pattern="\d*" type="text" size="6" maxlength="13" aria-label="Maximum Value in $"
        // class="x-textrange__input x-textrange__input--to" value="" autocomplete="off" aria-invalid="false">
        // class="x-textrange__input x-textrange__input--to"

        WebElement ikinciFiyatKutusu = driver.findElement(By.xpath("//input[@class='x-textrange__input x-textrange__input--to']\"));"));
        ikinciFiyatKutusu.sendKeys("10" + Keys.ENTER);

        WebElement aramaYap = driver.findElement(By.id("gh-btn"));

        WebElement siralamaYap = driver.findElement(By.name("aria-label"));

        WebElement sonucSayisi = driver.findElement(By.xpath("(\"//h1[@class='srp-controls__count-heading']"));

        System.out.println(sonucSayisi.getText());

        List<WebElement> listem = driver.findElements(By.xpath("(\"//h3[@class='s-item__title']"));
        for (WebElement w: listem) {
            System.out.println(w.getText());

        }





        // <span>Best Match</span>



    }
}
