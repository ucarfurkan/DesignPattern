package com.designpatterns.command;

import com.designpatterns.RecipeContext;
import com.designpatterns.entities.Category;
import com.designpatterns.entities.Recipe;
import com.designpatterns.entities.Tag;

import java.util.ArrayList;
import java.util.List;

public class SearchCommand implements Command {
    RecipeContext recipeContext;
    public SearchCommand() {
    }

    public SearchCommand(RecipeContext recipeContext) {
        this.recipeContext = recipeContext;
    }
    @Override
    public String getCommandName() {
        return "search";
    }

    @Override
    public void execute(Recipe recipe) {

    }

    public List<Recipe> search(String query) {
        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipeContext.getRecipies()) {
            for (Tag tag : recipe.getTags()) {
                if (tag.getName().contains(query)) {
                    matchingRecipes.add(recipe);
                    break;
                }
            }

            for (String ingredient : recipe.getIngredients()) {
                if (ingredient.contains(query)) {
                    matchingRecipes.add(recipe);
                    break;
                }
            }

            for (Category category : recipe.getCategories()) {
                if (category.getName().contains(query)) {
                    matchingRecipes.add(recipe);
                    break;
                }
            }
        }

        return matchingRecipes;
    }
}
