package com.zebrunner.carina.demo.gui.pages.ios;

import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductsListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    ExtendedWebElement removeButton;
    @ExtendedFindBy(accessibilityId = "test-CONTINUE SHOPPING")
    ExtendedWebElement continueShoppingButton;
    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    ExtendedWebElement checkoutButton;
    @ExtendedFindBy(accessibilityId = "test-Description")
    ExtendedWebElement productDescription;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickRemoveButton() {
        removeButton.click();
    }

    @Override
    public CheckoutPageBase clickCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    @Override
    public ProductsListPageBase clickContinueShoppingButton() {
        continueShoppingButton.click();
        return initPage(getDriver(), ProductsListPageBase.class);
    }

    @Override
    public boolean isDescriptionDisplayed() {
        return productDescription.isDisplayed();
    }

    @Override
    public boolean isYourCartTitleDisplayed() {
        return false;
    }
}
