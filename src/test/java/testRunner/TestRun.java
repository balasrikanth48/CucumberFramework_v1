package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features={".//Featurefile//Customer.feature"}	,
	monochrome=true ,
	glue="setpDefintion" ,
	dryRun=false,
	plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	tags="@regression")

public class TestRun
{
	
}
