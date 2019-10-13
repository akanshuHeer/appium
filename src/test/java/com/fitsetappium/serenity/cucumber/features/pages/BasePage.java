package com.fitsetappium.serenity.cucumber.features.pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends PageObject {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private static boolean isIOS;
    private static boolean isAndroid;

    public static void setAndroid(boolean android) {
        isAndroid = android;
    }

    public static boolean isAndroid() {
        return isAndroid;
    }

    public static void setIOS(boolean iOS) {
        isIOS = iOS;
    }

    public static boolean isIOS() {
        return isIOS;
    }

    //general
    public WebElement waitForElement(WebElement element) {
        return waitForElement(element, 10);
    }

    public WebElement waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void setText(WebElement element, String value) {
        typeInto(waitForElement(element), value);
        getDriver().navigate().back();
    }

    public String getText(WebElement element) {
        String txt = waitForElement(element).getText();
        if (txt.equals("")) {
            txt = element.getAttribute("value");
        }
        LOGGER.info(element.toString() + "  -  " + txt);
        return txt;
    }

    public void clickButtonUsingClassname(String className, String buttonName) throws InterruptedException {
        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("Click " + buttonName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(buttonName)) {
                getDriver().findElements(By.className(className)).get(i).click();
                return;
            }
        }
        if (i == len) {
            throw new InterruptedException("Element Not Found");
        }
    }

    public void scrollAndClick(String visibleText) {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade)facade).getProxiedDriver();
        ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    }

    public void waitForLoadPage() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int len = getDriver().findElements(By.className("android.widget.ProgressBar")).size();
            System.out.println("String len " + len);
            if (len == 0) {
                return;
            }
            Thread.sleep(999);
            LOGGER.info("Waiting for page to load");
        }
    }


}
