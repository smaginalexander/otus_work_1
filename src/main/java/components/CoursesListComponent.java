package components;

import annotations.Component;
import data.CategoryData;
import data.CourseData;
import driver.impl.IDriver;
import listenner.Listenner;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.time.LocalDate;
import java.util.*;

@Component("/")
public class CoursesListComponent extends AbstractComponent<CoursesListComponent> {

    Actions actions = new Actions(driver);
    String coursXpath = "//div[contains(text(),'%s')]/following::div[1]//div[contains(text(),'%s')]/..";

    public CoursesListComponent(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheNextCourse() {
        deletePopup();
        for (CourseData f : CourseData.values()) {
            if (f.getDate().equals(filterNextDateOfCourses())) {
                WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, f.getCategory(), f.getName())));
                cours.click();
            }
        }
    }

    public void clickOnTheNLastCourse() {
        deletePopup();
        for (CourseData f : CourseData.values()) {
            if (f.getDate().equals(filterLastDateOfCourses())) {
                WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, f.getCategory(), f.getName())));
                cours.click();
            }
        }
    }

    public String filterNextDateOfCourses() {
        List<LocalDate> dates = new ArrayList<>();
        for (CourseData f : CourseData.values()) {
            dates.add(LocalDate.parse(f.getDate()));
        }
        Optional<LocalDate> theNextDateFilter = dates.stream()
                .filter(date -> date.isAfter(LocalDate.now()))
                .min(LocalDate::compareTo);
        String theNextDate = theNextDateFilter.stream().findFirst().get().toString();
        return theNextDate;
    }

    public String filterLastDateOfCourses() {
        List<LocalDate> dates = new ArrayList<>();
        for (CourseData f : CourseData.values()) {
            dates.add(LocalDate.parse(f.getDate()));
        }
        Optional<LocalDate> theNextDateFilter = dates.stream()
                .filter(date -> date.isAfter(LocalDate.now()))
                .max(LocalDate::compareTo);
        String theNextDate = theNextDateFilter.stream().findFirst().get().toString();
        return theNextDate;
    }

    public void deletePopup() {
        actions.pause(2000).perform();
        WebElement popupCookie = driver.findElement(By.xpath("//div[@class='cookies__margin-block js-cookie']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'", popupCookie);

    }

    public void clickOnCours(CategoryData categoryData, String coursName) {
        deletePopup();
        WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, categoryData.getName(), coursName)));
        cours.click();
    }

}
