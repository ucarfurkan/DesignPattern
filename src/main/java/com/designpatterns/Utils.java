package com.designpatterns;

import com.designpatterns.entities.Category;
import com.designpatterns.entities.Tag;

import java.util.List;
import java.util.stream.Stream;

public class Utils {
    public static List<String> parseIngredients(String ingredients) {
        return List.of(ingredients.split(","));
    }

    public static List<Category> parseCategories(String categories) {
        return Stream.of(categories.split(",")).map(Category::fromString).toList();
    }

    public static List<Tag> parseTags(String tags) {
        return Stream.of(tags.split(",")).map(Tag::fromString).toList();
    }
}
