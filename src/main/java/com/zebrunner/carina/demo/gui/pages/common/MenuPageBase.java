package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage implements IMobileUtils {

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickLogoutBtn();
    public abstract void clickCloseBtn();
    public abstract void clickWebViewBtn();
    public abstract void clickDrawingBtn();
    public abstract void clickAboutBtn();

    public abstract MenuPageBase clickMenuIcon();
}
