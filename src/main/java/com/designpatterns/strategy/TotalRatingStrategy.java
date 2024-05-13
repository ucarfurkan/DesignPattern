package com.designpatterns.strategy;

import com.designpatterns.entities.Recipe;

public class TotalRatingStrategy implements CalculationStrategy {
    @Override
    public double calculateRating(Recipe recipe) {
        return recipe.getTotalRatings();
    }

    @Override
    public void updateRatings(Recipe recipe, int rating) {
        recipe.setTotalRatings(recipe.getTotalRatings() + 1);
    }
}
