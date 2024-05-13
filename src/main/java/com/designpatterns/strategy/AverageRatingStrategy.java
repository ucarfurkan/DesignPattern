package com.designpatterns.strategy;

import com.designpatterns.entities.Recipe;

public class AverageRatingStrategy implements CalculationStrategy {
    @Override
    public double calculateRating(Recipe recipe) {
        return recipe.getAverageRating();
    }

    @Override
    public void updateRatings(Recipe recipe, int rating) {
        recipe.setTotalRatings(recipe.getTotalRatings() + 1);
        recipe.setAverageRating((recipe.getAverageRating() * (recipe.getTotalRatings() - 1) + rating) / recipe.getTotalRatings());
    }
}
