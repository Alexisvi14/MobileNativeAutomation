package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.MenuPageBase;
import org.testng.annotations.Test;

public class LoginTests implements IAbstractTest {
    @Test(description = "Login with Standard credentials",groups = "login")
    @MethodOwner(owner = "Alexis")
    public void loginWithStandardCredentialsTest() throws InterruptedException {
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        sauceLabsLoginPage.clickStandardUser();
        var homePage = sauceLabsLoginPage.clickLoginButton();
        Thread.sleep(3000);
    }
    @Test(description = "Login writing problem user credentials")
    @MethodOwner(owner = "Alexis")
    public void loginWithProblemCredentialsTest(){
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        sauceLabsLoginPage.clickUsernameTextBox("problem_user");
        sauceLabsLoginPage.clickPasswordTextBox("secret_sauce");
        HomePageBase sauceLabsHomePage = sauceLabsLoginPage.clickLoginButton();
    }
    @Test(description = "Logout from standard_user credentials", dependsOnGroups = "login")
    @MethodOwner(owner = "Alexis")
    public void logoutUsingStandardCredentialsTest(){
        MenuPageBase sauceLabsMenuPage = initPage(getDriver(), MenuPageBase.class);
        sauceLabsMenuPage.clickMenuIcon();
        LoginPageBase sauceLabsLoginPage = sauceLabsMenuPage.clickLogoutBtn();
    }
}
