package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.gui.pages.common.*;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SauceLabsTestsAndroid implements IAbstractTest {

    @Test(description = "Login with Standard credentials")
    @MethodOwner(owner = "Alexis")
    public void loginWithStandardCredentialsTest() throws InterruptedException {
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        sauceLabsLoginPage.clickStandardUser();
        var homePage = sauceLabsLoginPage.clickLoginButton();
        Thread.sleep(3000);
    }

    @Test(description = "Change products view and select first item", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void changeProductsViewTest() throws InterruptedException {
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.clickChangeViewButton();
        ProductDetailPageBase sauceLabsDetailsPage = sauceLabsHomePage.clickProductByIndex("1");
        Assert.assertTrue(sauceLabsDetailsPage.isTitlePresent());
//        Assert.assertTrue();
    }
    @Test(description = "Add first product to the cart", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void addElementToCartTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = sauceLabsHomePage.clickCartButton();
        Assert.assertTrue(sauceLabsCartPage.isDescriptionDisplayed());
        sauceLabsCartPage.clickContinueShoppingButton();
    }
    @Test(description = "add product to the cart and complete the purchase", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void completePurchaseTest(){
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        HomePageBase sauceLabsHomePage = sauceLabsLoginPage.loginWithStandardCredentials();
        sauceLabsHomePage.addProductToCart("1");
        CartPageBase sauceLabsCartPage = sauceLabsHomePage.clickCartButton();
        CheckoutPageBase sauceLabsCheckoutPage = sauceLabsCartPage.clickCheckoutButton();
        sauceLabsCheckoutPage.completeCredentials("Micaela", "Villamayor", "3700");
        sauceLabsCheckoutPage.clickContinueBtn();
        sauceLabsCheckoutPage.clickFinishBtn();
    }
    @Test(description = "Login writing problem user credentials")
    @MethodOwner(owner = "Alexis")
    public void loginWithProblemCredentialsTest(){
        LoginPageBase sauceLabsLoginPage = initPage(getDriver(), LoginPageBase.class);
        sauceLabsLoginPage.clickUsernameTextBox("problem_user");
        sauceLabsLoginPage.clickPasswordTextBox("secret_sauce");
        HomePageBase sauceLabsHomePage = sauceLabsLoginPage.clickLoginButton();
    }

    @Test(description = "Click on first product using problem user credentials", dependsOnMethods = "loginWithProblemCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void goToFirstProductDetailsPageTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        ProductDetailPageBase sauceLabsProductsDetailsPage = sauceLabsHomePage.clickOnFirstElement();
        Assert.assertEquals(sauceLabsProductsDetailsPage.getProductPrice(), "$9.99");
    }

    @Test(description = "Add product from Product Details Page", dependsOnMethods = "loginWithProblemCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void addToCartFromProductDetailsPageTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        ProductDetailPageBase sauceLabsProductsDetailsPage = sauceLabsHomePage.clickOnFirstElement();
        sauceLabsProductsDetailsPage.clickAddToCartBtn();
    }
    @Test(description = "Logout from standard_user credentials", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void logoutUsingStandardCredentialsTest(){
        MenuPageBase sauceLabsMenuPage = initPage(getDriver(), MenuPageBase.class);
        sauceLabsMenuPage.clickMenuIcon();
        LoginPageBase sauceLabsLoginPage = sauceLabsMenuPage.clickLogoutBtn();
    }
    @Test(description = "Remove product from the cart", dependsOnMethods = {"loginWithStandardCredentialsTest", "addElementToCartTest"})
    @MethodOwner(owner = "Alexis")
    public void removeProductfromTheCartTest(){
        CartPageBase sauceLabsCartPage = initPage(getDriver(), CartPageBase.class);
        sauceLabsCartPage.clickRemoveButton();

    }
    @Test(description = "Add last product from the list to the cart and click on continue shopping", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void addLastProductToTheCartTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.clickProductByIndex("6");
    }
    @Test(description = "Sort Items by price from low to high", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void sortItemsByPriceTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);
        sauceLabsHomePage.selectFilterByText("Price (low to high)");
    }
    @Test(description = "Sort Items by price from low to high", dependsOnMethods = "loginWithStandardCredentialsTest")
    @MethodOwner(owner = "Alexis")
    public void addMultipleItemsToCartTest(){
        HomePageBase sauceLabsHomePage = initPage(getDriver(), HomePageBase.class);

    }
}
