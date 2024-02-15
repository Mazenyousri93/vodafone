package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class homePage {

    By cookiesDismissButton = By.xpath("//button[@class='onetrust-close-btn-handler banner-close-button ot-close-icon']");
    By smartPhoneButton = By.xpath("//button[@class='menuTab' and text()='Smart Phones ']");

    // Method to wait for cookies pop up to be visible then clish dismiss X button
    public void clickCookiesDismissButton(WebDriver driver){
        WebElement dismissButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(cookiesDismissButton));
    dismissButton.click();
}

    // Method to wait for smart phones button in the upper
    // menu to be visible then click it
    public void clickSmartPhoneButton(WebDriver driver){
        WebElement smartButton = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(smartPhoneButton));
        smartButton.click();
    }
}
