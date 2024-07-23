package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.enums.MenuOptions;
import com.zebrunner.carina.demo.gui.pages.common.ProductsListPageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests implements IAbstractTest {
    LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
    ProductsListPageBase productsListPageBase;
    @Test(description = "Login with Standard credentials")
    @MethodOwner(owner = "Alexis")
    public void loginWithStandardCredentialsTest() throws InterruptedException {
       productsListPageBase = loginPageBase.loginWithStandardCredentials();
       Assert.assertTrue(productsListPageBase.isProductsListPresent());

    }
    @Test(description = "Login writing problem user credentials")
    @MethodOwner(owner = "Alexis")
    public void loginWithProblemCredentialsTest() throws InterruptedException {
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        sauceLabsLoginPage.clickUsernameTextBox("problem_user");
        sauceLabsLoginPage.clickPasswordTextBox("secret_sauce");
        ProductsListPageBase sauceLabsHomePage = sauceLabsLoginPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertTrue(sauceLabsHomePage.isProductsListPresent());
    }
    @Test(description = "Logout from standard_user credentials", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void logoutUsingStandardCredentialsTest(){
        var loginpage = productsListPageBase.logout(MenuOptions.LOGOUT);
        Assert.assertTrue(loginpage.isLoginBtnPresent());
    }
}
