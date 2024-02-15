package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class smartPhonesPage {

    By searchBar = By.xpath("//input[@placeholder='Search For ...']");
    By appleButton = By.xpath("//div[@class='tab' and text()=' Apple ']");
    By firstResultsItem = By.xpath("//p[@id='mainText'][1]");
    By itemsDiv = By.xpath("//div[@class='product-cards vf-grid-wrap vf-grid-wrap-start']");


// Method to wait for page to fully load ( items div is visible and results are returned
    //Then enter the search value in the search bar field
    public void enterSearchWord(WebDriver driver,String searchItem){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(firstResultsItem));
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemsDiv));
        WebElement search = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchBar));
        search.sendKeys(searchItem);
    }
// Method to click the apple button in the search bar
    public void selectApple(WebDriver driver){

        WebElement apple = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(appleButton));
        apple.click();

    }
    // Method to validate the returned results against the search value
    public void assertSearchResults(WebDriver driver, String resultAssertion){
        WebElement result = new WebDriverWait(driver,Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(firstResultsItem));
        Assert.assertTrue(result.getText().contains(resultAssertion));

    }

}
