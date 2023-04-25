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
