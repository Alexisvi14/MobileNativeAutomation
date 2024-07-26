package com.zebrunner.carina.demo.gui.pages.ios;

import com.zebrunner.carina.demo.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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
    @ExtendedFindBy(accessibilityId = "THANK YOU FOR YOU ORDER")
    ExtendedWebElement thankYouForYourOrderText;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void completeCredentials(String firstName, String lastName, String zipCode) {
        firstNameTextBox.type(firstName);
        lastNameTextBox.type(lastName);
        zipCodeTextBox.type(zipCode);
    }

    @Override
    public void clickContinueBtn() {
        while (!continueButton.isPresent()){
            swipe(continueButton);
        }
        continueButton.click();
    }

    @Override
    public void clickFinishBtn() {
        while (!finishButton.isPresent()){
            swipe(finishButton);
        }
        finishButton.click();
    }

    @Override
    public boolean isThankYouForYourOrderTextPresent() {
        return thankYouForYourOrderText.isPresent();
    }
}
