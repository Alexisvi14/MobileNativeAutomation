package com.zebrunner.carina.demo.gui.components.ios;

import com.zebrunner.carina.demo.gui.components.common.HeaderMenuBase;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HeaderMenuBase.class)
public class HeaderMenu extends HeaderMenuBase {

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartBtn() {
        return null;
    }

    @Override
    public MenuPageBase clickMenuBtn() {
        return null;
    }
}
