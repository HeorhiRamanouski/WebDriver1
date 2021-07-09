package Hurt_Me_Plenty;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath="//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchButton;

    @FindBy(xpath="//*[contains(text(), 'My Button')])")
    private WebElement pasteExpirationMain;

    @FindBy(xpath="//ul[@id='select2-postform-expiration-results']/li[text()='10 Minutes']")
    private WebElement pasteExpirationTenMinutes;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//input[@class='devsite-search-field devsite-search-query']")));
        return this;
    }

    public HomePage textInput(String input ){

        searchButton.click();
        searchButton.sendKeys(input);
        searchButton.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage searchResultSelect(){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//div[@class='gs-title']//*[text()='Google Cloud Platform Pricing Calculator']")));
        driver.findElement(By.xpath("//div[@class='gs-title']//*[text()='Google Cloud Platform Pricing Calculator']")).click();
        return this;
    }



}
