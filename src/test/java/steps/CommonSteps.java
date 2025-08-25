package steps;

import core.TestContext;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    private final WebDriver driver;

    public CommonSteps(TestContext context){ this.driver = context.getDriver(); }

    @Given("I am on the ParaBank login page")
    public void i_am_on_login(){
        // Page opened in @Before hook
    }
}