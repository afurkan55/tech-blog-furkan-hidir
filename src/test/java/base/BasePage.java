package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public WebElement findElement(By by) {
        untilElementAppear(by);
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        untilElemetsAppear(by);
        return driver.findElements(by);
    }

    public void clickElement(By by) {
        untilElementClickable(by);
        findElement(by).click();
    }

    public void clickElements(By by , int index) {
        untilElementClickable(by);
        findElements(by).get(index).click();
    }

    public void sendKeys(By by, String text) {
        isElementDisplayed(by);
        findElement(by).sendKeys(text);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public String getAttribute(By by, String name) {
        return findElement(by).getAttribute(name);

    }

    public void selectOptionByValue(By by, String value) {
        Select select = new Select(findElement(by));
        select.selectByValue(value);
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public boolean isElementDisplayed(By by) {
        return findElement(by).isDisplayed();
    }


    public void untilElementAppear(By by) {
        System.out.println("Waiting until element presence...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void untilElemetsAppear(By by)
    {
        System.out.println("Waiting until elements presence ...");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void untilElementClickable(By by) {
        System.out.println("Waiting for element clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void analyzeLog() {
        LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }





}
