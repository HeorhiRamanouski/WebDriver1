package Bring_it_on;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class main_Test {

    private WebDriver driver;
    private String tabExpectedName = "how to gain dominance among developers";
    private String theCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @BeforeMethod (alwaysRun = true)
    public void setup (){
        driver = new ChromeDriver();
    }

    @Test
    public void testComplete() {

         new HomePage(driver)
                .openPage()
                .textInput(theCode)
                .pasteExpirationToTenMinutes()
                 .syntaxHighlightingToBash()
                .NameTitleInput(tabExpectedName)
                .pasteButtonClick ();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='left']/a[@class='btn -small h_800']")));

        String smth = driver.findElement(By.xpath("//div[@class='left']/a[@class='btn -small h_800']")).getText();

        PasteResultPage thePage = new PasteResultPage(driver);

        Assert.assertEquals(smth,"Bash","Syntax highlighting is not Bash");
        Assert.assertEquals(thePage.actualCode(),theCode,"The code is not correct");
        Assert.assertEquals(driver.getTitle(),tabExpectedName,"Tab name is not correct");


    }

    @AfterMethod (alwaysRun = true)
    public void shutDown() {
       driver.quit();
       driver=null;
   }
}
