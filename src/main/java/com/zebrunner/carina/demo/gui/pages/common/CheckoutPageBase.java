package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage implements IMobileUtils {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract void completeCredentials(String firstName, String lastName, String zipCode);
    public abstract void clickContinueBtn();
    public abstract void clickFinishBtn();
    public abstract boolean isThankYouForYourOrderTextPresent();
}
