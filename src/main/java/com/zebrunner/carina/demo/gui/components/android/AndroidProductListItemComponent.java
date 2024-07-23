package com.zebrunner.carina.demo.gui.components.android;

import com.zebrunner.carina.demo.gui.components.common.ProductListItemComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductListItemComponent extends ProductListItemComponent {

    public AndroidProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])")
    ExtendedWebElement product;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[%s]")
    ExtendedWebElement productWithIndex;
    @FindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])")
    ExtendedWebElement productPrice;
    @FindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])")
    ExtendedWebElement productTitle;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])")
    ExtendedWebElement addToCartButton;

    @Override
    public ExtendedWebElement getProduct() {
        return product;
    }

    @Override
    public ExtendedWebElement getProductByIndex(String index) {
        return productWithIndex.format(index);

    }
    @Override
    public String getProductPrice() {
        String text = productPrice.getText();
        String finalText = text.replace("$","").replace(".", "");
        return finalText;
    }

    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }

    @Override
    public ExtendedWebElement getProductTitleWebElement() {
        return productTitle;
    }

    @Override
    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    @Override
    public ExtendedWebElement getProductPriceWebElement() {
        return productPrice;
    }

}
