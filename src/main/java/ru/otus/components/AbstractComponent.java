package ru.otus.components;

import com.google.inject.Inject;
import org.openqa.selenium.interactions.Actions;
import ru.otus.annotations.Component;
import ru.otus.exceptions.ComponentIsNotExist;
import ru.otus.support.GuiceScoped;

public abstract class AbstractComponent<T> {
    protected GuiceScoped guiceScoped;

    protected Actions actions;
    private String baseUrl = System.getProperty("webDriver.base.url", "https://otus.ru");

    @Inject
    public AbstractComponent(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
        this.actions = new Actions(guiceScoped.driver);
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
        guiceScoped.driver.get(baseUrl + getPath());
        return (T) this;
    }

    }



