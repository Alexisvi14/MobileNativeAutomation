package com.zebrunner.carina.demo.gui.components.android;

import com.zebrunner.carina.demo.gui.components.common.FilterElementsBase;
import com.zebrunner.carina.demo.gui.enums.SortingType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterElementsAndroid extends FilterElementsBase {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement filterDropdownBtn;

    public FilterElementsAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public void sortBy(SortingType sortingType) {
        filterDropdownBtn.format(sortingType.getSortType()).click();
    }
}
