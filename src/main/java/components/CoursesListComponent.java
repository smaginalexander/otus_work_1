package components;

import annotations.Component;
import data.CategoryData;
import driver.impl.IDriver;
import listenner.Listenner;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

@Component("/")
public class CoursesListComponent extends AbstractComponent<CoursesListComponent> {

    Actions actions = new Actions(driver);

    public CoursesListComponent(WebDriver driver) {
        super(driver);
    }

    public List<String> getCoursesListText() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"lessons__new-item-time\"]"));
        List<String> elementsText = new ArrayList<>();
        elements.forEach(element -> {
            elementsText.add(element.getText());
        });
//        elementsText.forEach(string -> string.);
        return elementsText;
    }

    public void deletePopups() {
        actions.pause(2000).perform();
        WebElement popupCookie = driver.findElement(By.xpath("//div[@class='cookies__margin-block js-cookie']"));
//        WebElement popupHelp = driver.findElement(By.xpath("//div[@id='jcont']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.display='none'",popupCookie);

    }

    public void clickOnCours(CategoryData categoryData, String coursName) {
        deletePopups();
//        WebElement cours = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]/following::div[1]//div[contains(text(),'%s')]/.."
//                , categoryData.getName()
//                , coursName)));
//        cours.click();
        WebElement text = driver.findElement(By.xpath("//h1[contains(text(),'Авторские онлайн‑курсы')]"));
        text.click();
//        actions.moveToElement(cours).pause(3000).click().perform();
//        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'",cours);
    }

}
