package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.components.android.*;
import com.zebrunner.carina.demo.gui.components.common.FooterComponent;
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

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsListPageBase.class)
public class ProductsListPage extends ProductsListPageBase {

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])")
    List<AndroidProductListItemComponent> productListItems;
    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    AndroidProductListItemComponent products;
    @ExtendedFindBy(accessibilityId = "test-Menu")
    ExtendedWebElement burguerMenu;
    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"PRODUCTS\"]")
    AndroidBurguerMenuComponent menuOptions;
    @ExtendedFindBy(accessibilityId = "test-Toggle")
    ExtendedWebElement changeViewButton;
    @ExtendedFindBy(accessibilityId = "test-Cart")
    AndroidHeaderComponent cartButton;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]")
    ExtendedWebElement firstElement;
    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    ExtendedWebElement filterButton;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"Selector container\"`][1]")
    AndroidFilterComponent filterOption;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"\uF099 \uF09A \uF0D5 \uF0E1 © 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy\"`][2]")
    AndroidFooterComponent androidFooterComponent;


    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getPriceText(){
        productListItems.forEach(e-> System.out.println(e.getProductPrice()));
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
        ExtendedWebElement product = products.getProductByIndex(index);
        while (!product.isPresent() && !androidFooterComponent.isPresent()){
            swipe(product);
        }
        product.click();
        return initPage(getDriver(), ProductDetailPageBase.class);
    }

    @Override
    public void clickChangeViewButton() {
        changeViewButton.click();
    }

    @Override
    public void addProductToCart(String index) {
        products.clickAddToCartButton();
    }

    @Override
    public CartPageBase clickCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public void sortItems(SortingType sortingType) {
        openFilter();
        filterOption.sortBy(sortingType);
    }

    @Override
    public void openFilter() {
        filterButton.click();
    }

    @Override
    public boolean areItemsSortedByAscendingPrice() {
        List<Long> prices = new ArrayList<>();
            for (AndroidProductListItemComponent productListItem : productListItems) {
                try {
                    if (productListItem.getProductPriceWebElement().isElementPresent()){
                        String priceString = productListItem.getProductPrice();
                        Long price = Long.parseLong(priceString);
                        if (!prices.contains(price)){
                            prices.add(price);
                        } else {
                            break;
                        }
                    } else {
                        swipe(productListItem.getProductPriceWebElement());
                        String priceString = productListItem.getProductPrice();
                        Long price = Long.parseLong(priceString);
                        if (!prices.contains(price)) {
                            prices.add(price);
                        }else {
                            break;
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < prices.size() - 1; i++) {
                if (prices.get(i) > prices.get(i + 1)) {
                    return false;
                }
            }
        return true;
    }

    @Override
    public void addProductsToCart(List<String> productTitles) {

    }

    @Override
    public LoginPageBase logout(MenuOptions logoutOption) {
        openBurguerMenu();
        menuOptions.selectOption(logoutOption);
        return initPage(getDriver(),LoginPageBase.class);
    }

    @Override
    public boolean isProductsListPresent() {
        return !productListItems.isEmpty();
    }

    @Override
    public List<String> getAllProductsTitle() {
        List<String> productsToAdd = new ArrayList<>();
        do {
            for (AndroidProductListItemComponent productListItem : productListItems) {
                if (!productListItem.getProductTitleWebElement().isElementPresent()) {
                    swipe(productListItem.getProductTitleWebElement());
                }
                String productTitle = productListItem.getProductTitle();
                if (productListItem.getProductTitleWebElement().isElementPresent() && !productsToAdd.contains(productTitle)) {
                    productsToAdd.add(productTitle);
                }
            }

        } while (!androidFooterComponent.isPresent());
        return productsToAdd;
    }

    @Override
    public void addProductsToCartByTitle(List<String> productTitles) {
    Set<String> addedProducts = new HashSet<>();
    int maxIterations = 5;

    while (maxIterations > 0) {
        for (String product : productTitles) {
            if (addedProducts.contains(product)) {
                continue;
            }
            for (AndroidProductListItemComponent productListItem : productListItems) {
                try {
                    String productTitle = productListItem.getProductTitle();
                    if (product.equals(productTitle)) {
                        productListItem.clickAddToCartButton();
                        addedProducts.add(product);
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (addedProducts.size() == productTitles.size()) {
            break;
        }
        if (!swipe(androidFooterComponent.getAllRightsReservedText(), Direction.UP, 2, 600)) {
            maxIterations--;
        }
    }
    }
    @Override
    public ProductDetailPageBase clickOnFirstElement() {
        firstElement.click();
        return initPage(getDriver(), ProductDetailPageBase.class);
    }


}
