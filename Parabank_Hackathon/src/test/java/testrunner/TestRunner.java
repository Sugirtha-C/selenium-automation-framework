package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


/*
 * The TestRunner class integrates Cucumber with TestNG:
 * 
 * - Specifies the location of feature files and step definitions.
 * - Configures plugins for generating HTML and JSON reports.
 * 
 * Extends AbstractTestNGCucumberTests to enable TestNG support for Cucumber tests.
 */


@CucumberOptions(
		
		features="classpath:features",
		//features="src/test/resources/sample.feature",
		glue="step_definitions"	,
		plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

	
}
