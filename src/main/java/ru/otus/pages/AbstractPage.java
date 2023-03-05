package ru.otus.pages;

import ru.otus.annotations.Path;
import ru.otus.exceptions.PathIsEmtyException;
import ru.otus.support.GuiceScoped;

public abstract class AbstractPage<T> {
    protected GuiceScoped guiceScoped;
    private String baseUrl = System.getProperty("webDriver.base.url","https://otus.ru");

    public AbstractPage(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
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
        guiceScoped.driver.get(baseUrl + getPath());
        return (T) this;
    }

}
