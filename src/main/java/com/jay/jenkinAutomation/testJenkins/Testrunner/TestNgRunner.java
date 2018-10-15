package com.jay.jenkinAutomation.testJenkins.Testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "Featurefiles", glue= {"com.jay.jenkinAutomation.testJenkins.Stepdef"})
public class TestNgRunner extends AbstractTestNGCucumberTests{
	

}
