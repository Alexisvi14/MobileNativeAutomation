package com.zebrunner.carina.demo.gui.pages.ios;

import com.zebrunner.carina.demo.gui.enums.MenuOptions;
import com.zebrunner.carina.demo.gui.enums.SortingType;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductsListPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsListPageBase.class)
public class ProductsListPage extends ProductsListPageBase {
    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Item title\"])['%s']")
    ExtendedWebElement products;
    @FindBy(xpath = "add")
    ExtendedWebElement burguerMenu;
    @ExtendedFindBy(accessibilityId = "test-Toggle")
    ExtendedWebElement changeViewButton;
    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])['%s']")
    ExtendedWebElement addToCartButton;
    @ExtendedFindBy(accessibilityId = "test-Cart")
    ExtendedWebElement cartButton;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]")
    ExtendedWebElement firstElement;

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addProductsToCartByTitle(List<String> productTitles) {

    }

    @Override
    public ProductDetailPageBase clickOnFirstElement() {
        return null;
    }

    @Override
    public void getPriceText() {

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
    public void openBurguerMenu() {
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
        if (cartButton.isPresent()) {
            cartButton.click();
        }
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public void sortItems(SortingType sortingType) {

    }

    @Override
    public void openFilter() {

    }

    @Override
    public boolean areItemsSortedByAscendingPrice() {
        return false;
    }

    @Override
    public void addProductsToCart(List<String> productTitles) {

    }

    @Override
    public LoginPageBase logout(MenuOptions logoutOption) {
        return null;
    }

    @Override
    public boolean isProductsListPresent() {
        return false;
    }

    @Override
    public List<String> getAllProductsTitle() {
        return null;
    }

}
