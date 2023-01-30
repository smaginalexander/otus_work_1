package ui;

import annotations.Driver;
import components.CoursesListComponent;
import data.CategoryData;
import data.CourseData;
import exceptions.PathIsEmtyException;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class Courses_Test {

    @Driver
    protected WebDriver driver;


    @Test
    public void clickOnCourseFilteredByCourseName() throws PathIsEmtyException {
        new MainPage(driver).open();
        //Добавил категории, так как курсы в них могут повторятся
        new CoursesListComponent(driver).clickOnCours(CategoryData.POPULAR_COURSES, "Team Lead");
    }

    @Test
    public void clickOnTheNextCourse() throws PathIsEmtyException {
        new MainPage(driver).open();
        new CoursesListComponent(driver).clickOnTheNextCourse();
    }

    @Test
    public void clickOnTheNLastCourse() throws PathIsEmtyException {
        new MainPage(driver).open();
        new CoursesListComponent(driver).clickOnTheNLastCourse();
    }
}
