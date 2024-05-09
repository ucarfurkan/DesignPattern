package com.designpatterns.factory;

import com.designpatterns.command.CreateCommand;
import com.designpatterns.entities.Category;
import com.designpatterns.entities.Recipe;
import com.designpatterns.entities.Tag;

import java.util.List;
import java.util.stream.Stream;

import static com.designpatterns.Utils.parseCategories;
import static com.designpatterns.Utils.parseIngredients;
import static com.designpatterns.Utils.parseTags;

public class CreateRecipeFactory implements Factory {
    CreateCommand createCommand;

    public CreateRecipeFactory(CreateCommand createCommand) {
        this.createCommand = createCommand;
    }

    public void createRecipe(String name, String ingredients, String cookingInstructions, int servingSize, String categories, String tags) {
        var recipe = new Recipe(name, parseIngredients(ingredients), cookingInstructions, servingSize, parseCategories(categories), parseTags(tags));
        createCommand.execute(recipe);
    }




}
