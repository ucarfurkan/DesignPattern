package com.designpatterns.command;

import com.designpatterns.RecipeContext;
import com.designpatterns.entities.Recipe;

public class CreateCommand implements Command {
    RecipeContext recipeContext;

    public CreateCommand() {
    }

    public CreateCommand(RecipeContext recipeContext) {
        this.recipeContext = recipeContext;
    }

    @Override
    public String getCommandName() {
        return "create";
    }

    @Override
    public void execute(Recipe recipe) {
        recipeContext.getRecipies().add(recipe);
    }
}
