package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @ExtendedFindBy( accessibilityId = "test-standard_user")
    ExtendedWebElement standardUser;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    ExtendedWebElement loginButton;
    @FindBy(css = "#signin-error-msg")
    ExtendedWebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickStandardUser() {
        while (!standardUser.isPresent()){
            swipe(standardUser);
        }
        standardUser.click();
    }

    @Override
    public HomePageBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(),HomePageBase.class);
    }

    @Override
    public String getErrorMsg() {
        return errorMsg.getText();
    }

    @Override
    public HomePageBase loginWithStandardCredentials() {
        while (!standardUser.isPresent()){
            swipe(standardUser, 500);
        }
        standardUser.click();
        loginButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
