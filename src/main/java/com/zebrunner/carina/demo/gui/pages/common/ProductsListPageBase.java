package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.enums.MenuOptions;
import com.zebrunner.carina.demo.gui.enums.SortingType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.slf4j.Logger;

import java.util.List;

public abstract class ProductsListPageBase extends AbstractPage implements IMobileUtils {
    protected Logger logger;

    public ProductsListPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void addProductsToCartByTitle(List<String> productTitles);

    public abstract ProductDetailPageBase clickOnFirstElement();
    public abstract void getPriceText();

    public abstract void switchToWindow();

    public abstract void openBurguerMenu();

    public abstract ProductDetailPageBase clickProductByIndex(String index);

    public abstract void clickChangeViewButton();

    public abstract void addProductToCart(String index);
    public abstract CartPageBase clickCartButton();
    public abstract void sortItems(SortingType sortingType);
    public abstract void openFilter();
    public abstract boolean areItemsSortedByAscendingPrice();

    public abstract void addProductsToCart(List<String>productTitles);
    public abstract LoginPageBase logout(MenuOptions logoutOption);
    public abstract boolean isProductsListPresent();

    public abstract List<String> getAllProductsTitle();
}
