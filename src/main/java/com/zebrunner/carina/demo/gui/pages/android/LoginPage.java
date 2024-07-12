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
    @ExtendedFindBy( accessibilityId = "test-problem_user")
    ExtendedWebElement problemUser;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    ExtendedWebElement loginButton;
    @FindBy(css = "#signin-error-msg")
    ExtendedWebElement errorMsg;
    @ExtendedFindBy(accessibilityId = "test-Username")
    ExtendedWebElement usernameTextBox;
    @ExtendedFindBy(accessibilityId = "test-Password")
    ExtendedWebElement passwordTextBox;

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
    public void clickProblemUser() {
        while (!problemUser.isPresent()){
            swipe(problemUser);
        }
        problemUser.click();
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

    @Override
    public HomePageBase loginWithProblemCredentials() {
        while (!problemUser.isPresent()){
            swipe(problemUser, 500);
        }
        problemUser.click();
        loginButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public void clickUsernameTextBox(String username) {
        usernameTextBox.type(username);
    }

    @Override
    public void clickPasswordTextBox(String password) {
        passwordTextBox.type(password);
    }
}
