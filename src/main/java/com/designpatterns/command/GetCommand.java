package com.designpatterns.command;

import com.designpatterns.RecipeContext;
import com.designpatterns.entities.Recipe;

import java.util.List;

public class GetCommand implements Command {
    RecipeContext recipeContext;

    public GetCommand(RecipeContext recipeContext) {
        this.recipeContext = recipeContext;
    }

    @Override
    public String getCommandName() {
        return "get";
    }

    @Override
    public void execute(Recipe recipe) {

    }

    public void getRecipies() {
        recipeContext.getRecipies().stream().map(Recipe::toString).forEach(System.out::println);
    }

    public boolean hasRecipe(String recipeName) {
        return recipeContext.getRecipies().stream().anyMatch(recipe -> recipe.getName().equalsIgnoreCase(recipeName));
    }

    public Recipe getRecipe(String recipeName) {
        return recipeContext.getRecipies().stream().filter(recipe -> recipe.getName().equalsIgnoreCase(recipeName)).findFirst().orElse(null);
    }


}
