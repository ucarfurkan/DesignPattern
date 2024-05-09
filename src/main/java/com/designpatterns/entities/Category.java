package com.designpatterns.entities;

public enum Category {
    APPETIZERS("Appetizers"),
    MAIN_DISHIES("Main Dishes"),
    DESSERTS("Desserts");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category fromString(String text) {
        for (Category category : Category.values()) {
            if (category.name.equalsIgnoreCase(text)) {
                return category;
            }
        }
        return null;
    }
}
