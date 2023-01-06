package components;

import annotations.Component;
import data.CategoryData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CategoryPage;
@Component("/")
public class MainMenuComponent extends AbstractComponent<MainMenuComponent> {
    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    private String menuItemTemplate = "#categories_id a[title='%s']";

    public CategoryPage clickOnCategory(CategoryData categoryData) {
        String selector = String.format(menuItemTemplate, categoryData.getName());
        driver.findElement(By.cssSelector(selector)).click();
        return new CategoryPage(driver);
    }
}
