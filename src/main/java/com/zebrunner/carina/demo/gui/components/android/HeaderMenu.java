package com.zebrunner.carina.demo.gui.components.android;

import com.zebrunner.carina.demo.gui.components.common.HeaderMenuBase;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeaderMenuBase.class)
public class HeaderMenu extends HeaderMenuBase {
    @ExtendedFindBy(accessibilityId = "test-Cart")
    ExtendedWebElement cartBtn;
    @ExtendedFindBy(accessibilityId = "test-Menu")
    ExtendedWebElement menuBtn;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartBtn() {
        cartBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMenuBtn() {
        menuBtn.click();
        return initPage(getDriver(), MenuPageBase.class);
    }
}
