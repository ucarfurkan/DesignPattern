package com.designpatterns.command;

import com.designpatterns.RecipeContext;
import com.designpatterns.entities.Recipe;

public class RateCommand implements Command {
    RecipeContext recipeContext;

    public RateCommand() {
    }

    public RateCommand(RecipeContext recipeContext) {
        this.recipeContext = recipeContext;
    }
    @Override
    public String getCommandName() {
        return "rate";
    }

    @Override
    public void execute(Recipe recipe) {

    }
}
