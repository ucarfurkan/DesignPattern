package com.designpatterns.command;

import com.designpatterns.RecipeContext;
import com.designpatterns.entities.Recipe;

public class ModifyCommand implements Command {

    RecipeContext recipeContext;
    Recipe exRecipe;

    public ModifyCommand() {
    }

    public ModifyCommand(RecipeContext recipeContext) {
        this.recipeContext = recipeContext;
    }
    @Override
    public String getCommandName() {
        return "modify";
    }

    @Override
    public void execute(Recipe recipe) {
        deleteRecipe(recipe.getName());
        recipeContext.getRecipies().add(recipe);
    }

    public void setExRecipe(Recipe exRecipe) {
        this.exRecipe = new Recipe(exRecipe.getName(), exRecipe.getIngredients(), exRecipe.getCookingInstructions(), exRecipe.getServingSize(), exRecipe.getCategories(),exRecipe.getTags());
    }

    public void undo() {
        recipeContext.getRecipies().removeIf(recipe -> recipe.getName().equalsIgnoreCase(exRecipe.getName()));
        recipeContext.getRecipies().add(exRecipe);
    }

    public void deleteRecipe(String recipeName) {
        recipeContext.getRecipies().removeIf(recipe -> recipe.getName().equalsIgnoreCase(recipeName));
    }
}
