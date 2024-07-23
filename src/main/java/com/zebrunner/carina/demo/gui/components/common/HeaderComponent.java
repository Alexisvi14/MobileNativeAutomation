package com.zebrunner.carina.demo.gui.components.common;

import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderComponent extends AbstractUIObject {


    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CartPageBase clickCartBtn();
}
