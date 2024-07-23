package com.zebrunner.carina.demo.gui.components.ios;

import com.zebrunner.carina.demo.gui.components.common.HeaderComponent;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class IOSHeaderComponent extends HeaderComponent {


    public IOSHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase clickCartBtn() {
        return null;
    }

}
