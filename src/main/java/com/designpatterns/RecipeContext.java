package com.designpatterns;

import com.designpatterns.entities.Recipe;

import java.util.List;

public class RecipeContext {
    List<Recipe> recipies;

    public RecipeContext(List<Recipe> recipies) {
        this.recipies = recipies;
    }

    public List<Recipe> getRecipies() {
        return recipies;
    }

    public void setRecipies(List<Recipe> recipies) {
        this.recipies = recipies;
    }
}
