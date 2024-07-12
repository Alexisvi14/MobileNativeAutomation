package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoginPageBase extends AbstractPage implements IMobileUtils {
    protected Logger logger;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        this.logger = LoggerFactory.getLogger(this.getClass());
    }
    public abstract void clickStandardUser();
    public abstract void clickProblemUser();
    public abstract HomePageBase clickLoginButton();
    public abstract String getErrorMsg();

    public abstract HomePageBase loginWithStandardCredentials();
    public abstract HomePageBase loginWithProblemCredentials();

    public abstract void clickUsernameTextBox(String username);
    public abstract void clickPasswordTextBox(String password);
}
