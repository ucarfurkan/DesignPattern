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
        recipeContext.getRecipies();
        for (int i = 1; i < recipeContext.getRecipies().size() + 1; i++) {
            System.out.println(i + ". " + recipeContext.getRecipies().get(i-1).getName());
        }
    }

    public Recipe getRecipe(int index) {
        return recipeContext.getRecipies().get(index);
    }

    public boolean hasRecipe(String recipeName) {
        return recipeContext.getRecipies().stream().anyMatch(recipe -> recipe.getName().equalsIgnoreCase(recipeName));
    }

    public Recipe getRecipe(String recipeName) {
        return recipeContext.getRecipies().stream().filter(recipe -> recipe.getName().equalsIgnoreCase(recipeName)).findFirst().orElse(null);
    }


}
