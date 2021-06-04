package runners;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/BuscadorTierragro.feature",
		glue = "stepsDefinitions",
		snippets = SnippetType.CAMELCASE)
public class BuscadorTierragroRunner {

}







