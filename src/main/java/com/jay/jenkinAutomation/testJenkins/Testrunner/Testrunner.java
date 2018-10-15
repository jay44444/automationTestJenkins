package com.jay.jenkinAutomation.testJenkins.Testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Featurefiles", glue= {"automation.Stepdef"})
public class Testrunner {

	
}
