package ru.otus.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Допустим;
import ru.otus.exceptions.PathIsEmtyException;
import ru.otus.pages.MainPage;

public class MainPageSteps {
    @Inject
    private MainPage mainPage;

    @Допустим("Открываем главную страницу через браузер {string}")
    public void openMainPage(String browser) throws PathIsEmtyException {
        mainPage.open();
    }

}
