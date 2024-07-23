package com.zebrunner.carina.demo.gui.components.ios;

import com.zebrunner.carina.demo.gui.components.common.FilterComponent;
import com.zebrunner.carina.demo.gui.enums.SortingType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class IOSFilterComponent extends FilterComponent {
    public IOSFilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortingType sortingType) {

    }
}
