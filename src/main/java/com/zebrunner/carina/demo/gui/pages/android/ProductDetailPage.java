package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    ExtendedWebElement productTitle;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return productTitle.isPresent();
    }


    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }
}
