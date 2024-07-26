package com.zebrunner.carina.demo.gui.components.ios;

import com.zebrunner.carina.demo.gui.components.common.BurguerMenuComponent;
import com.zebrunner.carina.demo.gui.enums.MenuOptions;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IOSBurguerMenuComponent extends BurguerMenuComponent {

    public IOSBurguerMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @ExtendedFindBy(iosPredicate = "name == \"test-Menu\"")
    ExtendedWebElement menuOption;
    @Override
    public void selectOption(MenuOptions option) {
        menuOption.format(option.getMenuOptions()).click();
    }
}
