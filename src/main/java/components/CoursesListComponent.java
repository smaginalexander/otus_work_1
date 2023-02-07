package components;

import annotations.Component;
import data.CourseData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("/")
public class CoursesListComponent extends AbstractComponent<CoursesListComponent> {

    private String coursXpath = "//div[contains(text(),'%s')]/following::div[1]//div[contains(text(),'%s')]/..";

    public CoursesListComponent(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheNextCourse() {
        deletePopup();
        for (CourseData courseData : CourseData.values()) {
            if (courseData.getDate().equals(filterNextDateOfCourses())) {
                WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, courseData.getCategory(), courseData.getName())));
                System.out.println("ближайший курс " + courseData.getName() + "стартует " + courseData.getDate());
                cours.click();
            }
        }
    }

    public void clickOnTheLastCourse() {
        deletePopup();
        for (CourseData courseData : CourseData.values()) {
            if (courseData.getDate().equals(filterLastDateOfCourses())) {
                WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, courseData.getCategory(), courseData.getName())));
                System.out.println("Последний курс " + courseData.getName() + "стартует " + courseData.getDate());
                cours.click();
            }
        }
    }

    public String filterNextDateOfCourses() {
        Optional<LocalDate> theNextDateFilter = getListOfDatesCourses().stream().filter(date -> date.isAfter(LocalDate.now())).
        reduce((maxDate, curDate) -> maxDate.isBefore(curDate) ?
                LocalDate.parse(maxDate.toString()) : LocalDate.parse(curDate.toString()));
        String theNextDate = theNextDateFilter.stream().findFirst().get().toString();
        return theNextDate;
    }

    public String filterLastDateOfCourses() {
        Optional<LocalDate> theLastDateFilter = getListOfDatesCourses().stream().
                reduce((maxDate, curDate) -> maxDate.isAfter(curDate) ?
                        LocalDate.parse(maxDate.toString()) : LocalDate.parse(curDate.toString()));
        String theLustDate = theLastDateFilter.stream().findFirst().get().toString();
        return theLustDate;
    }

    //Дублирующая часть кода ванесена в отельный метод
    public List<LocalDate> getListOfDatesCourses() {
        List<LocalDate> dates = new ArrayList<>();
        for (CourseData courseData : CourseData.values()) {
            dates.add(LocalDate.parse(courseData.getDate()));
        }
        return dates;
    }

    public void deletePopup() {
        actions.pause(2000).perform();
        WebElement popupCookie = driver.findElement(By.xpath("//div[@class='cookies__margin-block js-cookie']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'", popupCookie);
    }

    public void clickOnCours(String category, String coursName) {
        deletePopup();
        WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, category, coursName)));
        cours.click();
    }

}
