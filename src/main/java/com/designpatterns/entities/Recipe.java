package com.designpatterns.entities;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private List<String> ingredients;
    private String cookingInstructions;
    private int servingSize;
    private List<Category> categories;
    private List<Tag> tags;

    public Recipe(String name, List<String> ingredients, String cookingInstructions, int servingSize, List<Category> categories, List<Tag> tags) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
        this.servingSize = servingSize;
        this.categories = categories;
        this.tags = tags;
    }

    public Recipe() {
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return servingSize == recipe.servingSize && Objects.equals(name, recipe.name) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(cookingInstructions, recipe.cookingInstructions) && Objects.equals(categories, recipe.categories) && Objects.equals(tags, recipe.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients, cookingInstructions, servingSize, categories, tags);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", cookingInstructions='" + cookingInstructions + '\'' +
                ", servingSize=" + servingSize +
                ", categories=" + categories +
                ", tags=" + tags +
                '}';
    }
}
