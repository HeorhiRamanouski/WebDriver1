package I_Can_Win;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class main_Test {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void setup (){
        driver = new ChromeDriver();
    }

    @Test
    public void testComplete() throws InterruptedException {
         new HomePage (driver)
                .openPage()
                .textInput("Hello from WebDriver")
                .pasteExpirationToTenMinutes()
                .NameTitleInput("helloweb");

    }

    @AfterMethod (alwaysRun = true)
    public void shutDown() {
       driver.quit();
       driver=null;
   }
}
