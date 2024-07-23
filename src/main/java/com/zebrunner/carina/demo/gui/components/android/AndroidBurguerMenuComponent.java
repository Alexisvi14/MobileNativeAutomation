package com.zebrunner.carina.demo.gui.components.android;

import com.zebrunner.carina.demo.gui.components.common.BurguerMenuComponent;
import com.zebrunner.carina.demo.gui.enums.MenuOptions;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidBurguerMenuComponent extends BurguerMenuComponent {

    public AndroidBurguerMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-%s\"]/android.widget.TextView")
    ExtendedWebElement menuOption;

    @Override
    public void selectOption(MenuOptions option) {
        menuOption.format(option.getMenuOptions()).click();
    }
}
