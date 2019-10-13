package com.fitsetappium.serenity.cucumber.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report"},
        features={"src/test/resources/features/login/login.feature",
                "src/test/resources/features/Home/home.feature"
        })
public class AcceptanceTestRunner {

    @Managed
    WebDriver driver;
}
