package ru.otus.support;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import ru.otus.driver.DriverFactory;

@ScenarioScoped
public class GuiceScoped {
    public WebDriver driver = new DriverFactory().getDriver();

}
