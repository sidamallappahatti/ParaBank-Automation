package steps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoanRequestPage;
import static org.testng.Assert.assertEquals;

public class LoanSteps {
    private final WebDriver driver;
    private final LoanRequestPage loan;

    public LoanSteps(TestContext context){
        this.driver = context.getDriver();
        this.loan = new LoanRequestPage(driver);
    }

    @When("I navigate to Request Loan")
    public void open_request_loan(){ loan.open(); }

    @When("I request a loan of {string} with down payment {string} from account {string}")
    public void request(String amount, String down, String account){
        loan.requestLoan(amount, down, account);
    }

    @Then("the loan request should be {string}")
    public void verify_status(String expected){
        assertEquals(loan.getStatus(), expected);
    }

    @Then("the new balance should reflect the loan disbursement")
    public void verify_balance(){
        // TODO: navigate to Accounts Overview and assert balances
    }
}