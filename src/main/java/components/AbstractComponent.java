package components;

import annotations.Component;
import exceptions.ComponentIsNotExist;
import exceptions.PathIsEmtyException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class AbstractComponent<T> {
    protected WebDriver driver;
    protected Actions actions;
    private String baseUrl = System.getProperty("webDriver.base.url", "https://otus.ru");

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    private String getPath() throws ComponentIsNotExist {
        Class clazz = this.getClass();
        if (clazz.isAnnotationPresent(Component.class)) {
            Component path = (Component) clazz.getAnnotation(Component.class);
            return path.value();
        }
        throw new ComponentIsNotExist();
    }

    public T open() throws ComponentIsNotExist {
        driver.get(baseUrl + getPath());
        return (T) this;
    }


}
