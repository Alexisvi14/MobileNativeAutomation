package com.zebrunner.carina.demo.gui.components.common;

import com.zebrunner.carina.demo.gui.enums.SortingType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class FilterElementsBase extends AbstractUIObject {

    public FilterElementsBase(WebDriver driver) {
        super(driver);
    }

    public abstract void sortBy(SortingType sortingType);
}
