package Hurt_Me_Plenty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pricingCalculatorPage {
    private WebDriver driver;

    @FindBy(id="input_66")
    private WebElement numOfInstancesInput;

    @FindBy(id="select_value_label_59")
    private WebElement operSystemsList;

    @FindBy(id="select_option_68")
    private WebElement freeOSinput;

    @FindBy(id="select_value_label_60")
    private WebElement machineClassList;

    @FindBy(id="select_option_68")
    private WebElement machineClassRegular;

    @FindBy(id="select_value_label_63")
    private WebElement machineTypeList;

    @FindBy(id="select_option_246")
    private WebElement machineTypeStandard;

    @FindBy(xpath="//*[@aria-label='Add GPUs']")
    private WebElement addGpuCheckbox;

    @FindBy(id="select_value_label_374")
    private WebElement numberOfGpuList;

    @FindBy(id="select_option_396")
    private WebElement numberOfGpuToFour;

    @FindBy(xpath="//form[@name='SoleTenantForm']//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement estimateButton;

    public pricingCalculatorPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public pricingCalculatorPage fillIn(){

        numOfInstancesInput.click();
        numOfInstancesInput.sendKeys("4");
        operSystemsList.click();
        freeOSinput.click();
        machineClassList.click();
        machineClassRegular.click();
        machineTypeList.click();
        machineTypeStandard.click();
        addGpuCheckbox.click();
        numberOfGpuList.click();
        numberOfGpuToFour.click();
        estimateButton.click();

        return this;
    }


}
