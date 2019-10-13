package com.fitsetappium.serenity.cucumber.features.stepdefinitions;

import com.fitsetappium.serenity.cucumber.features.pages.BasePage;
import com.fitsetappium.serenity.cucumber.features.steps.Steps;
import com.fitsetappium.serenity.cucumber.features.utils.TestDataSetup;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitions {

    public static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitions.class);

    @net.thucydides.core.annotations.Steps
    Steps steps;

    @Before
    public void setPlatform() {
        String platform = System.getProperty("testEnvironment");
        if (platform == null) {
            platform = "Android";
        }
        LOGGER.info("The platform is " + platform);
        if (platform.compareToIgnoreCase("android") == 0) {
            BasePage.setAndroid(true);
            BasePage.setIOS(false);
        } else {
            BasePage.setAndroid(false);
            BasePage.setIOS(true);
        }
    }
    @Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
        LOGGER.info("user is on login page");
        steps.user_is_on_login_page();
    }

    @Then("^user opens registration page$")
    public void user_opens_registration_page() throws Throwable {
        steps.user_opens_registration_page();
    }
    @Given("^user clicks on signup link$")
    public void user_clicks_on_signup_link() throws Throwable{
        steps.user_clicks_on_signup_link();
    }
        @Then("^verify that plan page is shown$")
    public void verify_that_plan_page_is_shown() throws Throwable{
        steps.verify_that_plan_page_is_shown();
    }
}
