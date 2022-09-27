package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features={".//Featurefile//Customer.feature",".//Featurefile//login.feature"}	,
	monochrome=false ,
	glue="setpDefintion" ,
	dryRun=true ,
	plugin={"pretty" ,"html:target/cucumber-reportst.html"},
	tags= "@sanity ,@regression"
	)

public class TestRun
{
	
}
