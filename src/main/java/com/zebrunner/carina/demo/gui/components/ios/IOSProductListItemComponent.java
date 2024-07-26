package com.zebrunner.carina.demo.gui.components.ios;

import com.zebrunner.carina.demo.gui.components.common.ProductListItemComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IOSProductListItemComponent extends ProductListItemComponent {

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"test-Item\"])")
    ExtendedWebElement product;
    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"test-Item\"])[%s]")
    ExtendedWebElement productWithIndex;
    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Price\"])")
    ExtendedWebElement productPrice;
    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Item title\"])")
    ExtendedWebElement productTitle;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])")
    ExtendedWebElement addToCartButton;

    public IOSProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

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
    public WebElement getProductTitleWebElement() {
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
