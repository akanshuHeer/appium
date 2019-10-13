package com.fitsetappium.serenity.cucumber.features.steps;

import com.fitsetappium.serenity.cucumber.features.pages.*;
import com.fitsetappium.serenity.cucumber.features.teststripeapi.TestStripeApi;
import com.fitsetappium.serenity.cucumber.features.utils.TestDataSetup;
import com.stripe.exception.*;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.List;


public class Steps extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(Steps.class);

    private LoginPage loginPage;
    TestStripeApi testStripeAPI;

    @Step
    public void user_is_on_login_page() throws Throwable {
        Assert.assertEquals(true, loginPage.isEmailFieldDisplayed());
    }
    @Step
    public void user_clicks_on_signup_link() throws Throwable{
        loginPage.clickSignUpLink();
    }
    @Step
    public void verify_that_plan_page_is_shown() throws Throwable{
        Assert.assertEquals(loginPage.getJogPlanText(),"Jog Plan");
        Assert.assertEquals(loginPage.getRunPlanText(),"Run Plan");
        Assert.assertEquals(loginPage.getSprintPlanText(),"Sprint Plan");
    }
    @Step
    public void user_opens_registration_page() throws Throwable {
        loginPage.clickSignUpLink();
        Assert.assertEquals("Step 1 of 3", loginPage.getHelloMsg());
    }

    @Step
    public void user_enter_username_and_and_password_as_and_click_Login_button(String email, String password) throws Throwable {
        loginPage.login(email, password);
    }

}
