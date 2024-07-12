package com.zebrunner.carina.demo.gui.components.common;

import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractPage implements IMobileUtils {
    public HeaderMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickCartBtn();
    public abstract MenuPageBase clickMenuBtn();
}
