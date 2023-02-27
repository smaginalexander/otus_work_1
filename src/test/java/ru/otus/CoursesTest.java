package ru.otus;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ru.otus.annotations.Driver;
import ru.otus.components.CoursesListComponent;
import ru.otus.exceptions.PathIsEmtyException;
import ru.otus.extensions.UIExtension;
import ru.otus.pages.MainPage;

//@ExtendWith(UIExtension.class)
@Cucumber
public class CoursesTest {

//    @Driver
//    protected WebDriver driver;
//
//
//    @Test
//    //    Клик по курсу, найденному по названию
//    public void clickOnCourseFilteredByCourseName(String category, String courseName) throws PathIsEmtyException {
//        new MainPage(driver).open();
//        //Добавил категории, так как курсы в них могут повторятся
//        new CoursesListComponent(driver).clickOnCours(category, courseName);
//    }
//
//    //    Клик по ближайшему курсу
//    @Test
//    public void clickOnTheNextCourse() throws PathIsEmtyException {
//        new MainPage(driver).open();
////        new CoursesListComponent(driver).clickOnTheNextCourse();
//    }
//
//    //    Клик по последнему курсу
//    @Test
//    public void clickOnTheNLastCourse() throws PathIsEmtyException {
//        new MainPage(driver).open();
//        new CoursesListComponent(driver).clickOnTheLastCourse();
//    }
}
