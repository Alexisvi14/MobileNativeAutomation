package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPage implements IMobileUtils {
    protected Logger logger;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract ProductDetailPageBase clickOnFirstElement();

    public abstract void switchToWindow();

    public abstract void clickBurguerMenu();

    public abstract ProductDetailPageBase clickProductByIndex(String index);

    public abstract void clickChangeViewButton();

    public abstract void addProductToCart(String index);
    public abstract CartPageBase clickCartButton();

    public abstract void selectFilterByText(String filterText);
}
