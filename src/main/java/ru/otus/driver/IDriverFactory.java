package ru.otus.driver;

import ru.otus.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    WebDriver getDriver() throws DriverTypeNotSupported;
}