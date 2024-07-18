package com.zebrunner.carina.demo.gui.enums;

public enum SortingType {
    PRICE_LOW_TO_HIGH("Price (low to high)"), PRICE_HIGH_TO_LOW("Price (high to low)"), AZ("Name (A to Z)"), ZA("Name (Z to A)");

    private final String sortingType;

    SortingType(String sortType) {
        this.sortingType = sortType;
    }

    public String getSortType() {
        return sortingType;
    }
}
