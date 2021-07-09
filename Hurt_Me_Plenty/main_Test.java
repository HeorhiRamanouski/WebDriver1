package Hurt_Me_Plenty;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class main_Test {

    private WebDriver driver;
    private String searchInput = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod (alwaysRun = true)
    public void setup (){
        driver = new ChromeDriver();
    }

    @Test
    public void testComplete() throws InterruptedException {
         new HomePage(driver)
                .openPage()
                .textInput(searchInput)
                .searchResultSelect();

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[@id='input_66']")));


        pricingCalculatorPage pageInput = new pricingCalculatorPage(driver);
        pageInput.fillIn();
         driver.wait(100);

    }

 @AfterMethod (alwaysRun = true)
 public void shutDown() {
     driver.quit();
     driver=null;
  }
}
