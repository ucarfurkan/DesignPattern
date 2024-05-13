package com.designpatterns.entities;

import com.designpatterns.strategy.AverageRatingStrategy;
import com.designpatterns.strategy.CalculationStrategy;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private List<String> ingredients;
    private String cookingInstructions;
    private int servingSize;
    private List<Category> categories;
    private List<Tag> tags;
    private int totalRatings;
    private double averageRating;
    private CalculationStrategy calculationStrategy;

    public Recipe(String name, List<String> ingredients, String cookingInstructions, int servingSize, List<Category> categories, List<Tag> tags) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
        this.servingSize = servingSize;
        this.categories = categories;
        this.tags = tags;
        this.calculationStrategy = new AverageRatingStrategy();
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


    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void addRating(int rating) {
        calculationStrategy.updateRatings(this, rating);
    }

    public CalculationStrategy getCalculationStrategy() {
        return calculationStrategy;
    }

    public void setCalculationStrategy(CalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    @Override
    public String toString() {
        return
                name +
                ", ingredients=" + ingredients +
                ", cookingInstructions='" + cookingInstructions + '\'' +
                ", servingSize=" + servingSize +
                ", categories=" + categories +
                ", tags=" + tags +
                ", rating=" + calculationStrategy.calculateRating(this);
    }
}
