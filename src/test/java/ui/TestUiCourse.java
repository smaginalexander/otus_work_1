package ui;

import annotations.Driver;
import components.MainMenuComponent;
import data.CategoryData;
import exceptions.ComponentIsNotExist;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class TestUiCourse {
    @Driver
    protected WebDriver driver;

        public TestUiCourse(WebDriver driver) {
        this.driver = driver;
    }
    @Test
    public void clickOnCategory()  {
        new MainPage(driver).open();
    }
}
