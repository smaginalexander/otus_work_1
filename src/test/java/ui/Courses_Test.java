package ui;

import annotations.Driver;
import components.CoursesListComponent;
import data.CourseData;
import exceptions.PathIsEmtyException;
import extensions.UIExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(UIExtension.class)
public class Courses_Test {
    @Driver
    protected WebDriver driver;

//  start test on selenoid
    @BeforeEach
    void setupTest() throws MalformedURLException {
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "109.0");
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("selenoid:options", selenoidOptions);
        driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
    }


    @Test
    //    Клик по курсу, найденному по названию
    public void clickOnCourseFilteredByCourseName() throws PathIsEmtyException, MalformedURLException {
        new MainPage(driver).open();
        //Добавил категории, так как курсы в них могут повторятся
        new CoursesListComponent(driver).clickOnCours(CourseData.СИСТЕМНЫЙ_АНАЛИТИК.getCategory(), "Специализация Системный аналитик");
    }

    //    Клик по ближайшему курсу
    @Test
    public void clickOnTheNextCourse() throws PathIsEmtyException {
        new MainPage(driver).open();
        new CoursesListComponent(driver).clickOnTheNextCourse();
    }

    //    Клик по последнему курсу
    @Test
    public void clickOnTheNLastCourse() throws PathIsEmtyException {
        new MainPage(driver).open();
        new CoursesListComponent(driver).clickOnTheLastCourse();
    }
}
