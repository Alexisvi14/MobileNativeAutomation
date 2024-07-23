package com.zebrunner.carina.demo.gui.components.android;

import com.zebrunner.carina.demo.gui.components.common.HeaderComponent;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidHeaderComponent extends HeaderComponent {
    @ExtendedFindBy(accessibilityId = "test-Cart")
    ExtendedWebElement cartBtn;
    @ExtendedFindBy(accessibilityId = "test-Menu")
    ExtendedWebElement menuBtn;
    @FindBy(xpath = "//android.widget.TextView[@text= '%s']")
    ExtendedWebElement numberOfElementsInCartIcon;

    public AndroidHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase clickCartBtn() {
        cartBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

}
