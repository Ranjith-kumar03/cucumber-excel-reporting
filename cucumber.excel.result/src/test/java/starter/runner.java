package starter;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features=("src//test//java//features"),glue= {"implement"},plugin= {"pretty","html:target/cucumber"},tags= {"@TestExcel"})

@Test
public class runner extends AbstractTestNGCucumberTests{
	
	

}
