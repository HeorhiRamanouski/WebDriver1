package Bring_it_on;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteResultPage {

    protected WebDriver driver;

    @FindBy(xpath="//div[@class='left']/a[@class='btn -small h_800']")
    private WebElement highlightType;

    @FindBy(xpath="//textarea[@class='textarea']")
    private WebElement pasteAreaResult;

    public PasteResultPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public String actualCode(){
        return pasteAreaResult.getText();
    }

}
