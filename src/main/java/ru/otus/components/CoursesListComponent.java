package ru.otus.components;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.otus.annotations.Component;
import ru.otus.data.CourseData;
import ru.otus.support.GuiceScoped;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("/")
public class CoursesListComponent extends AbstractComponent<CoursesListComponent> {

    private String coursXpath = "//div[contains(text(),'%s')]/following::div[1]//div[contains(text(),'%s')]/..";

    @Inject
    public CoursesListComponent(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void clickOnTheNextCourse(String userDate) {
        for (CourseData courseData : CourseData.values()) {
            if (courseData.getDate().equals(filterNextDateOfCourses(userDate))) {
                WebElement cours = guiceScoped.driver.findElement(By.xpath(String.format(coursXpath, courseData.getCategory(), courseData.getName())));
                System.out.println("ближайший курс " + courseData.getName() + "стартует " + courseData.getDate());
                cours.click();
                return;
            }
        }
    }

    public void clickOnTheСheapestCourse() {
        for (CourseData courseData : CourseData.values()) {
            if (courseData.getPrise().equals(findSmallestNumber())) {
                WebElement cours = guiceScoped.driver.findElement(By.xpath(String.format(coursXpath, courseData.getCategory(), courseData.getName())));
                System.out.println("самый дешевый курс " + courseData.getName() + " стоит " + courseData.getPrise());
                cours.click();
                return;
            }
        }
    }

    public void clickOnTheExpensiveCourse() {
        for (CourseData courseData : CourseData.values()) {
            if (courseData.getPrise().equals(findMaxNumber())) {
                WebElement cours = guiceScoped.driver.findElement(By.xpath(String.format(coursXpath, courseData.getCategory(), courseData.getName())));
                System.out.println("самый дорогой курс " + courseData.getName() + " стоит " + courseData.getPrise());
                cours.click();
                return;
            }
        }
    }


    public void clickOnTheLastCourse() {
        deletePopup();
        for (CourseData courseData : CourseData.values()) {
            if (courseData.getDate().equals(filterLastDateOfCourses())) {
                WebElement cours = guiceScoped.driver.findElement(By.xpath(String.format(coursXpath, courseData.getCategory(), courseData.getName())));
                System.out.println("Последний курс " + courseData.getName() + "стартует " + courseData.getDate());
                cours.click();
            }
        }
    }

    public String filterNextDateOfCourses(String userDate) {
        Optional<LocalDate> theNextDateFilter = getListOfDatesCourses().stream().filter(date -> date.isAfter(LocalDate.parse(userDate))).
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

    public List<LocalDate> getListOfDatesCourses() {
        List<LocalDate> dates = new ArrayList<>();
        for (CourseData courseData : CourseData.values()) {
            dates.add(LocalDate.parse(courseData.getDate()));
        }
        return dates;
    }

    public List<Integer> getPriseList() {
        List<Integer> priseList = new ArrayList<>();
        for (CourseData courseData : CourseData.values()) {
            priseList.add(courseData.getPrise());
        }
        return priseList;
    }

    public int findSmallestNumber() {
        List<Integer> priseList = getPriseList();
        int smallestPrise = Integer.MAX_VALUE;
        for (int prise : priseList) {
            if (prise < smallestPrise) {
                smallestPrise = prise;
            }
        }
        return smallestPrise;
    }

    public int findMaxNumber() {
        List<Integer> priseList = getPriseList();
        int maxPrise = Integer.MIN_VALUE;
        for (int number : priseList) {
            if (number > maxPrise) {
                maxPrise = number;
            }
        }
        return maxPrise;
    }


    public void deletePopup() {
        actions.pause(3000).perform();
        WebElement popupCookie = guiceScoped.driver.findElement(By.xpath("//div[contains(@class, 'cookies__margin-block')]"));
        WebElement helpPopup = guiceScoped.driver.findElement(By.xpath("//jdiv[@id='jvlabelWrap']"));
        ((JavascriptExecutor) guiceScoped.driver).executeScript("arguments[0].style.display='none'", popupCookie);
        ((JavascriptExecutor) guiceScoped.driver).executeScript("arguments[0].style.display='none'", helpPopup);
    }

    public void clickOnCours(String category, String coursName) {
        WebElement cours = guiceScoped.driver.findElement(By.xpath(String.format(coursXpath, category, coursName)));
        cours.click();
    }

}
