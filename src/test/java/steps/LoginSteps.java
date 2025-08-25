package steps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private final WebDriver driver;
    private final LoginPage loginPage;

    public LoginSteps(TestContext context){
        this.driver = context.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @When("I login as {string} with password {string}")
    public void i_login(String user, String pass){
        loginPage.login(user, pass);
    }

    @Then("I should see the Accounts Overview page")
    public void i_should_see_overview(){
        assertTrue(driver.findElement(By.linkText("Accounts Overview")).isDisplayed());
    }
}