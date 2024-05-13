package com.designpatterns.strategy;

import com.designpatterns.entities.Recipe;

public interface CalculationStrategy {
    double calculateRating(Recipe recipe);
    void updateRatings(Recipe recipe, int rating);
}
