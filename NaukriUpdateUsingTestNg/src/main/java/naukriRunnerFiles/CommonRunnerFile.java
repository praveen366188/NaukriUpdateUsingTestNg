package naukriRunnerFiles;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "C:\\Users\\user\\Desktop\\pravi\\NaukriUpdate\\src\\main\\java\\naukriFeatures\\naukriLogin.feature"
 ,glue={"stepDefenition"}
 )
public class CommonRunnerFile {

}