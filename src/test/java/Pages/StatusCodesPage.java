package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {
    private WebDriver driver;
    private By link200 = By.linkText("200");
    private By link301 = By.linkText("301");
    private By link404 = By.linkText("404");
    private By link500 = By.linkText("500");
    private By bodyText = By.cssSelector("body");

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStatusCodeLink(String statusCode) {
        switch (statusCode) {
            case "200":
                driver.findElement(link200).click();
                break;
            case "301":
                driver.findElement(link301).click();
                break;
            case "404":
                driver.findElement(link404).click();
                break;
            case "500":
                driver.findElement(link500).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid status code: " + statusCode);
        }
    }

    public String getBodyText() {
        return driver.findElement(bodyText).getText();
    }
}
