package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])['%s']")
    ExtendedWebElement products;
    @FindBy(xpath = "add")
    ExtendedWebElement burguerMenu;
    @ExtendedFindBy(accessibilityId = "test-Toggle")
    ExtendedWebElement changeViewButton;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])['%s']")
    ExtendedWebElement addToCartButton;
    @ExtendedFindBy(accessibilityId = "test-Cart")
    ExtendedWebElement cartButton;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]")
    ExtendedWebElement firstElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void switchToWindow(){
        String parent = getDriver().getWindowHandle();
        Set<String> handles=getDriver().getWindowHandles();
        for (String handle:handles) {
            System.out.println(handle);
            if (!handle.equals(parent)){
                getDriver().switchTo().window(handle);
                break;
            }
        }
    }

    @Override
    public void clickBurguerMenu() {
        burguerMenu.click();
    }

    @Override
    public ProductDetailPageBase clickProductByIndex(String index) {
        products = products.format(index);
        products.click();
        return initPage(getDriver(), ProductDetailPageBase.class);
    }

    @Override
    public void clickChangeViewButton() {
        changeViewButton.click();
    }

    @Override
    public void addProductToCart(String index) {
        addToCartButton = addToCartButton.format(index);
        addToCartButton.click();
    }

    @Override
    public CartPageBase clickCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public ProductDetailPageBase clickOnFirstElement() {
        firstElement.click();
        return initPage(getDriver(), ProductDetailPageBase.class);
    }
}
