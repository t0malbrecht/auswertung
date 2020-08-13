package com.company.services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverUtil {
    private WebDriver driver;
    private JavascriptExecutor js;

    public DriverUtil(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }
    public boolean verifyPage(String url) {
        return driver.getCurrentUrl().equals(url);
    }
    public void selectOption(String menu, String option){
        Select genderSelect = new Select(driver.findElement(By.name(menu)));
        genderSelect.selectByValue(option);
    }
    public void scrollToElement(String xPath) throws InterruptedException, IndexOutOfBoundsException {
        WebElement element = driver.findElement(By.xpath(xPath));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickElement(String xPath) throws InterruptedException {
        driver.findElement(By.xpath(xPath)).click();
    }

}
