package com.zebrunner.carina.demo.gui.pages.ios;

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

    @ExtendedFindBy(accessibilityId = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.")
    ExtendedWebElement productTitle;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return productTitle.isPresent();
    }

    @Override
    public boolean isImgPresent() {
        return false;
    }

    @Override
    public String getProductPrice() {
        return null;
    }

    @Override
    public void clickAddToCartBtn() {

    }

    @Override
    public boolean validateNumberOfElementsInCartIconIsPresent(String number) {
        return false;
    }

    @Override
    public CartPageBase clickOnCartBtn() {
        return null;
    }


    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }
}
