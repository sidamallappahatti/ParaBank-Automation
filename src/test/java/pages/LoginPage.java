package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginBtn = By.cssSelector("input[value='Log In']");

    public LoginPage(WebDriver driver){ this.driver = driver; }

    public void login(String user, String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}