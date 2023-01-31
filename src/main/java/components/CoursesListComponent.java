package components;

import annotations.Component;
import data.CourseData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                System.out.println("ближайший курс "+f.getName()+ "стартует "+ f.getDate());
                cours.click();
            }
        }
    }

    public void clickOnTheLastCourse() {
        deletePopup();
        for (CourseData f : CourseData.values()) {
            if (f.getDate().equals(filterLastDateOfCourses())) {
                WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, f.getCategory(), f.getName())));
                System.out.println("Последний курс "+f.getName()+ "стартует "+ f.getDate());
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
        Optional<LocalDate> theLastDateFilter = dates.stream()
                .filter(date -> date.isAfter(LocalDate.now()))
                .max(LocalDate::compareTo);
        String theLustDate = theLastDateFilter.stream().findFirst().get().toString();
        return theLustDate;
    }

    public void deletePopup() {
        actions.pause(2000).perform();
        WebElement popupCookie = driver.findElement(By.xpath("//div[@class='cookies__margin-block js-cookie']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'", popupCookie);
    }

    public void clickOnCours(String category, String coursName) {
        deletePopup();
        WebElement cours = driver.findElement(By.xpath(String.format(coursXpath, category, coursName)));
        //При использовании Actions, click() не добавляет стили
        //actions.moveToElement(cours).click().perform();
        cours.click();
    }

}
