package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailPageBase extends AbstractPage implements IMobileUtils {

    public ProductDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitle();
    public abstract boolean isTitlePresent();
    public abstract boolean isImgPresent();

    public abstract String getProductPrice();
    public abstract void clickAddToCartBtn();
    public abstract boolean validateNumberOfElementsInCartIconIsPresent(String number);

    public abstract CartPageBase clickOnCartBtn();
}
