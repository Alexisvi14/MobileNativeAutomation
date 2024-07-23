package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage implements IMobileUtils {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickRemoveButton();
    public abstract CheckoutPageBase clickCheckoutButton();
    public abstract ProductsListPageBase clickContinueShoppingButton();

    public abstract boolean isDescriptionDisplayed();

    public abstract boolean isYourCartTitleDisplayed();
}
