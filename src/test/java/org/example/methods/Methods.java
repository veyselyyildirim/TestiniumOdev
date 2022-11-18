package org.example.methods;


import org.example.driver.ProjeBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = ProjeBaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
        // java script ile scroll.

    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }
    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void Enter(String id){
        driver.findElement(By.id(id)).sendKeys(Keys.ENTER);
    }

    public void clickByCss(String css){
        driver.findElement(By.cssSelector(css)).click();
    }

    public void clickByXpath(String xpath){
        driver.findElement(By.id(xpath)).click();
    }
    public void sendKeysById(String id,String mesaj){
        driver.findElement(By.id(id)).sendKeys(mesaj);
    }
    public void sendKeysByCss(String css,String mesaj){
        driver.findElement(By.id(css)).sendKeys(mesaj);
    }
    public void sendKeysByXpath(String xpath,String mesaj){
        driver.findElement(By.id(xpath)).sendKeys(mesaj);
    }

    /*fare ile üstüne gelme*/
    public void hover(By by){
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }


    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
        logger.info("Sendkey İşlemi gerçekleştirildi");
    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();

    }

    public Select getSelect(By by) {

        return new Select(findElement(by));

    }

    public void selectByText(By by, String text) {

        getSelect(by).selectByVisibleText(text);
    }

    public void scrollWithjavaScript(By by) {
        jsdriver.executeScript("arguments[0].scrollIntoView();", findElement(by));

    }

    public String getAttribute(By by, String attributeName) {

        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by) {
        return findElement(by).getText();

    }


    public String urlal(){
        String a;
        a=driver.getCurrentUrl();
        return a;
    }

    public void setText() {


    }
    public String getValue(By by){

        return jsdriver.executeScript("return arguments[0].value",findElement(by)).toString();

    }

    public boolean isElementVisible(By by) {
        logger.info("");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        } catch (Exception e) {
            logger.info("False" + e.getMessage());
            return false;
        }
    }

    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
