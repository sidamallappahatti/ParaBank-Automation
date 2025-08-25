package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoanRequestPage {
    private final WebDriver driver;
    private final By requestLoanLink = By.linkText("Request Loan");
    private final By amount = By.id("amount");
    private final By downPayment = By.id("downPayment");
    private final By fromAccount = By.id("fromAccountId");
    private final By applyBtn = By.cssSelector("input[value='Apply Now']");
    private final By status = By.id("loanStatus");

    public LoanRequestPage(WebDriver driver){ this.driver = driver; }

    public void open(){ driver.findElement(requestLoanLink).click(); }
    public void requestLoan(String amt, String down, String account){
        driver.findElement(amount).clear();
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(downPayment).clear();
        driver.findElement(downPayment).sendKeys(down);
        new Select(driver.findElement(fromAccount)).selectByVisibleText(account);
        driver.findElement(applyBtn).click();
    }
    public String getStatus(){ return driver.findElement(status).getText(); }
}