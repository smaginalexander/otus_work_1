package ru.otus.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import ru.otus.exceptions.PathIsEmtyException;
import ru.otus.pages.MainPage;

public class MainPageSteps {

    @Inject
    private MainPage mainPage;

    @Пусть("открываем главную страницу")
    public void openMainPage() throws PathIsEmtyException {
        mainPage.open();
    }


}
