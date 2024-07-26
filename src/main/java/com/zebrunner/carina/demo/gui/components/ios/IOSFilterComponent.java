package com.zebrunner.carina.demo.gui.components.ios;

import com.zebrunner.carina.demo.gui.components.common.FilterComponent;
import com.zebrunner.carina.demo.gui.enums.SortingType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IOSFilterComponent extends FilterComponent {

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement filterDropdownBtn;
    public IOSFilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortingType sortingType) {
        filterDropdownBtn.format(sortingType.getSortType()).click();
    }
}
