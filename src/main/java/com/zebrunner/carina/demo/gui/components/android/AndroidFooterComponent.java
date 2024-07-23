package com.zebrunner.carina.demo.gui.components.android;

import com.zebrunner.carina.demo.gui.components.common.FooterComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFooterComponent extends FooterComponent {

    public AndroidFooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[5]")
    ExtendedWebElement allRightsReservedText;

    @Override
    public ExtendedWebElement getAllRightsReservedText() {
        return allRightsReservedText;
    }
}
