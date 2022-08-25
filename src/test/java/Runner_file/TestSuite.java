package Runner_file;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"C://Users//Abhinav Kashyap//IdeaProjects//Member_Portal//src//main//resources//Feature//Home_Page.feature"},
        glue = {"StepDefinition"}
)

public class TestSuite {
}