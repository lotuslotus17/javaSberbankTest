package com.sberbank;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"},
        glue = {"com.sberbank"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class TestRunner {
}