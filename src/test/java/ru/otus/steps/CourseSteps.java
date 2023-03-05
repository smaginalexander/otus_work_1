package ru.otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Допустим;
import ru.otus.components.CoursesListComponent;

public class CourseSteps {
    @Inject
    CoursesListComponent coursesListComponent;

    @Допустим("В категории {string} выбираем {string}")
    public void clickOnCours(String category, String coursName) {
        coursesListComponent.clickOnCours(category, coursName);
    }

    @Допустим("Закрываем всплывающие окна")
    public void clickOnCours() {
        coursesListComponent.deletePopup();
    }

    @Допустим("Выбираем ближайший курс на дату {string}")
    public void filterNextDateOfCourses(String date) {
        coursesListComponent.clickOnTheNextCourse(date);
    }
    @Допустим("Выбираем самый поздний курс")
    public void clickOnTheLastCourse() {
        coursesListComponent.clickOnTheLastCourse();
    }

    @Допустим("Выбираем самый дешевый курс")
    public void clickOnTheСheapestCourse() {
        coursesListComponent.clickOnTheСheapestCourse();
    }

    @Допустим("Выбираем самый дорогой курс")
    public void clickOnTheExpensiveCourse() {
        coursesListComponent.clickOnTheExpensiveCourse();
    }

}

