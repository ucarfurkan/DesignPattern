package com.designpatterns.factory;

import com.designpatterns.command.GetCommand;
import com.designpatterns.command.ModifyCommand;

import static com.designpatterns.Utils.parseCategories;
import static com.designpatterns.Utils.parseIngredients;
import static com.designpatterns.Utils.parseTags;

public class ModifyRecipeFactory implements Factory {

    ModifyCommand modifyCommand;
    GetCommand getCommand;

    public ModifyRecipeFactory(ModifyCommand modifyCommand, GetCommand getCommand) {
        this.modifyCommand = modifyCommand;
        this.getCommand = getCommand;
    }

    public void modifyRecipe(String name, String ingredients, String cookingInstructions, String categories, String tags) {
        var recipe = getCommand.getRecipe(name);
        modifyCommand.setExRecipe(recipe);
        recipe.setIngredients(parseIngredients(ingredients));
        recipe.setCookingInstructions(cookingInstructions);
        recipe.setCategories(parseCategories(categories));
        recipe.setTags(parseTags(tags));
        modifyCommand.execute(recipe);
    }
}
