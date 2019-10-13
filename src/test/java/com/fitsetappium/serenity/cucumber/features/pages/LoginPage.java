package com.fitsetappium.serenity.cucumber.features.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSFindBy(xpath = "ios:id/email")
    @FindBy(xpath = "android.widget.EditText")
    private WebElement editText_email;

    public boolean isEmailFieldDisplayed() throws InterruptedException {
        return waitForElement(editText_email, 20).isDisplayed();
    }

    public void login(String email, String password) throws InterruptedException {
        waitForElement(editText_email).clear();
        waitForElement(editText_email).sendKeys(email);
        getDriver().findElements(By.className("android.widget.EditText")).get(1).clear();
        setText(getDriver().findElements(By.className("android.widget.EditText")).get(1),  password);
        clickButtonUsingClassname("android.widget.TextView", "LOGIN");
    }

    public void setEmail(String email) throws InterruptedException {
        waitForElement(editText_email).sendKeys(email);
    }

    @AndroidFindBy(id = "android:id/message")
    @iOSFindBy(xpath = "ios:id/message")
    @FindBy(xpath = "android:id/message")
    private WebElement errorMessage;

    public String getErrorMsg() throws InterruptedException {
        return waitForElement(errorMessage).getText();
    }

    @AndroidFindBy(id = "android:id/button1")
    @iOSFindBy(xpath = "ios:id/message")
    @FindBy(xpath = "android.widget.TextView")
    private WebElement btn_ok;

    public void clickOkBtn() {
        btn_ok.click();
    }

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement helloMessage;

    public String getHelloMsg() throws InterruptedException {
        Thread.sleep(5999);
        waitForLoadPage();
        return getText(helloMessage);
    }

    public void clickForgotPassword() throws InterruptedException {
        clickButtonUsingClassname("android.widget.TextView", "Forgot Password");
    }

    public void clickSendResetLink() throws InterruptedException {
        clickButtonUsingClassname("android.widget.TextView", "SEND RESET LINK");
    }

    public void clickSignUpLink() throws InterruptedException {
        clickButtonUsingClassname("android.widget.TextView", "Dont have an account? Sign up");
    }

    public String getJogPlanText()throws InterruptedException{
       return getDriver().findElement(By.xpath("//android.widget.TextView[@text='Jog Plan']")).getText();
    }
    public String getRunPlanText()throws InterruptedException{
        return getDriver().findElement(By.xpath("//android.widget.TextView[@text='Run Plan']")).getText();
    }
    public String getSprintPlanText()throws InterruptedException{
        return getDriver().findElement(By.xpath("//android.widget.TextView[@text='Sprint Plan']")).getText();
    }
    public void clickOnNextButton()throws InterruptedException{
        scrollAndClick("NEXT");
        //clickButtonUsingClassname("android.widget.TextView","NEXT");
    }

    public String getAltertMsg()throws InterruptedException{
        String str=getDriver().findElement(By.id("android:id/message")).getText();
        return str;
    }
    public void clickOnOkBtn()throws InterruptedException{
        getDriver().findElement(By.id("android:id/button1")).click();
    }
    public void clickOngetJogPlan()throws InterruptedException{

        getDriver().findElements(By.className("android.view.ViewGroup")).get(5).click();
    }
    public String getFirstName()throws InterruptedException{
        waitForLoadPage();
        String str=getDriver().findElements(By.className("android.widget.TextView")).get(0).getText();
        System.out.println("String firstName "+str);
        return str;
    }



}
