package com.designpatterns.entities;

public enum Tag {

    VEGETARIAN("Vegetarian"),
    GLUTEN_FREE("Gluten Free"),
    SPICY("Spicy");

    private final String name;

    Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Tag fromString(String text) {
        for (Tag category : Tag.values()) {
            if (category.name.equalsIgnoreCase(text)) {
                return category;
            }
        }
        return null;
    }
}

