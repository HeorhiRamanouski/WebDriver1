package I_Can_Win;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    @FindBy(id="postform-text")
    private WebElement searchTextArea;

    @FindBy(xpath="//*[@id=\"postform-name\"]")
    private WebElement pasteName;

    @FindBy(xpath="//*[@id=\"select2-postform-expiration-container\"]")
    private WebElement pasteExpirationMain;

    @FindBy(xpath="//ul[@id='select2-postform-expiration-results']/li[text()='10 Minutes']")
    private WebElement pasteExpirationTenMinutes;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("postform-text")));
        return this;
    }

    public HomePage textInput(String input ){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/form/div[2]/div/div/div/input")));
        searchTextArea.sendKeys(input);
        return this;
    }

    public HomePage pasteExpirationToTenMinutes(){
        pasteExpirationMain.click();
        pasteExpirationTenMinutes.click();
        return this;
    }

    public HomePage NameTitleInput(String input ){
        pasteName.sendKeys(input);
        return this;
    }


}
