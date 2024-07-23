package com.zebrunner.carina.demo.gui.pages.ios;

import com.zebrunner.carina.demo.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    ExtendedWebElement firstNameTextBox;
    @ExtendedFindBy(accessibilityId = "test-Last Name")
    ExtendedWebElement lastNameTextBox;
    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    ExtendedWebElement zipCodeTextBox;
    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    ExtendedWebElement continueButton;
    @ExtendedFindBy(accessibilityId = "test-FINISH")
    ExtendedWebElement finishButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void completeCredentials(String firstName, String lastName, String zipCode) {

    }

    @Override
    public void clickContinueBtn() {

    }

    @Override
    public void clickFinishBtn() {

    }

    @Override
    public boolean isThankYouForYourOrderTextPresent() {
        return false;
    }
}
