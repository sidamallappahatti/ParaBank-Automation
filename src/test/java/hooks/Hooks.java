package hooks;

import core.ConfigReader;
import core.DriverFactory;
import core.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    private final TestContext context;
    public Hooks(TestContext context){ this.context = context; }

    @Before
    public void before(){
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        DriverFactory.initDriver(headless);
        context.setDriver(DriverFactory.getDriver());
        context.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            byte[] ss = ((TakesScreenshot)context.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment("Failed Screenshot", "image/png", "png", ss);
        }
        DriverFactory.quitDriver();
    }
}