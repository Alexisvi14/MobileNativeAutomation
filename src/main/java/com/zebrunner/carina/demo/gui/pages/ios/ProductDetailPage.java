package com.zebrunner.carina.demo.gui.pages.ios;

import com.zebrunner.carina.demo.gui.components.android.AndroidHeaderComponent;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"%s\"]")
    ExtendedWebElement productTitle;

    @ExtendedFindBy(accessibilityId = "test-Image Container")
    ExtendedWebElement productImage;

    @ExtendedFindBy(accessibilityId = "test-Price")
    ExtendedWebElement productPrice;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    AndroidHeaderComponent cartButton;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"%s\"])[4]")
    ExtendedWebElement numberOfElementsInCartIcon;


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return productTitle.isPresent();
    }

    @Override
    public boolean isImgPresent() {
        return productImage.isPresent();
    }

    @Override
    public String getProductPrice() {
        while (!productPrice.isPresent()){
            swipe(productPrice);
        }
        return productPrice.getText();
    }

    @Override
    public void clickAddToCartBtn() {
        while (!addToCartBtn.isPresent()){
            swipe(addToCartBtn);
        }
        addToCartBtn.click();
    }

    @Override
    public boolean validateNumberOfElementsInCartIconIsPresent(String number) {
        numberOfElementsInCartIcon = numberOfElementsInCartIcon.format(number);
        return numberOfElementsInCartIcon.isDisplayed();
    }

    @Override
    public CartPageBase clickOnCartBtn() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }


    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }
}
