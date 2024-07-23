package com.zebrunner.carina.demo.gui.components.common;

import com.zebrunner.carina.demo.gui.enums.MenuOptions;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class BurguerMenuComponent extends AbstractUIObject {
    public BurguerMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public abstract void selectOption(MenuOptions option);
}
