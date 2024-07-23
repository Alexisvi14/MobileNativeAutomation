package com.zebrunner.carina.demo.gui.enums;

public enum MenuOptions {
    ALL_ITEMS("ALL ITEMS"), WEB_VIEW("WEB VIEW"), QR_CODE_SCANNER("QR CODE SCANNER"), GEO_LOCATION("GEO LOCATION"), DRAWING("DRAWING"), ABOUT("ABOUT"), LOGOUT("LOGOUT"), RESET_APP_STATE("RESET APP STATE");

    private String menuOptions;

    MenuOptions(String menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String getMenuOptions() {
        return menuOptions;
    }
}
