package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-Close")
    ExtendedWebElement closeBtn;
    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    ExtendedWebElement logoutBtn;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    ExtendedWebElement menuIcon;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickLogoutBtn() {
        logoutBtn.click();
        return initPage(getDriver(),LoginPageBase.class);
    }

    @Override
    public void clickCloseBtn() {
        closeBtn.click();
    }

    @Override
    public void clickWebViewBtn() {

    }

    @Override
    public void clickDrawingBtn() {

    }

    @Override
    public void clickAboutBtn() {

    }

    @Override
    public MenuPageBase clickMenuIcon() {
        menuIcon.click();
        return initPage(getDriver(), MenuPageBase.class);
    }
}
