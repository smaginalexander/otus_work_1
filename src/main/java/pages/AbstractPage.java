package pages;

import annotations.Path;
import exceptions.PathIsEmtyException;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage<T> {
    protected WebDriver driver;
    private String baseUrl = System.getProperty("webDriver.base.url","https://otus.ru");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    private String getPath() throws PathIsEmtyException {
        Class clazz = this.getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = (Path) clazz.getAnnotation(Path.class);
            return path.value();
        }
        throw new PathIsEmtyException();
    }

    public T open() throws PathIsEmtyException {
        driver.get(baseUrl + getPath());
        return (T) this;
    }

}
