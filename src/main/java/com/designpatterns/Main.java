package com.designpatterns;

import com.designpatterns.command.*;
import com.designpatterns.entities.Category;
import com.designpatterns.entities.Recipe;
import com.designpatterns.entities.Tag;
import com.designpatterns.factory.CreateRecipeFactory;
import com.designpatterns.factory.ModifyRecipeFactory;
import com.designpatterns.strategy.AverageRatingStrategy;
import com.designpatterns.strategy.TotalRatingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Recipe> recipeList = new ArrayList<>();
        var yumurta = new Recipe("Yumurta", List.of("yumurta,yağ"), "tavaya yağ dök, yumurtayı kır, karıştır.", 1, List.of(Category.MAIN_DISHIES),List.of(Tag.SPICY));
        var makarna = new Recipe("Makarna", List.of("makarna,su"), "tencereye su koy, kaynat, makarnayı at, pişir.", 1, List.of(Category.MAIN_DISHIES),List.of(Tag.SPICY));
        var context = new RecipeContext(recipeList);
        context.getRecipies().add(yumurta);
        context.getRecipies().add(makarna);

        var greetings = "Welcome to the Recipe Management System!\n";

        while (true) {
            System.out.println(greetings);

            var createCmd = new CreateCommand(context);
            var modifyCmd = new ModifyCommand(context);
            var searchCmd = new SearchCommand(context);
            var rateCmd = new RateCommand();
            var getCmd = new GetCommand(context);

            var createFactory = new CreateRecipeFactory(createCmd);
            var modifyFactory = new ModifyRecipeFactory(modifyCmd, getCmd);

            System.out.println("Please select an option from the following commands:");
            var options = List.of(createCmd.getCommandName(), modifyCmd.getCommandName(), searchCmd.getCommandName(), rateCmd.getCommandName(), getCmd.getCommandName());
            options.forEach(System.out::println);

            System.out.println("Enter your command:");
            var command = scanner.nextLine();

            switch (command) {
                case "get":
                    System.out.println("Choose the recipe to view:");
                    getCmd.getRecipies();
                    var recipeI = scanner.nextInt();
                    scanner.nextLine();
                    var recipe = getCmd.getRecipe(recipeI - 1);
                    System.out.println("How do you want to see the ratings?");
                    System.out.println("1. Average rating");
                    System.out.println("2. Total ratings");
                    var ratingOption = scanner.nextInt();
                    scanner.nextLine();
                    if (ratingOption == 1) {
                       recipe.setCalculationStrategy(new AverageRatingStrategy());
                    } else {
                        recipe.setCalculationStrategy(new TotalRatingStrategy());
                    }
                    System.out.println(recipe);
                    break;
                case "create":
                    System.out.println("Enter the recipe name:");
                    var recipeName = scanner.nextLine();
                    System.out.println("Enter the recipe ingredients (separate with ','):");
                    var recipeIngredients = scanner.nextLine();
                    System.out.println("Enter the recipe cooking instructions:");
                    var recipeCookingInstructions = scanner.nextLine();
                    System.out.println("Enter the recipe serving size:");
                    var recipeServingSize = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the recipe categories (separate with ','):");
                    var recipeCategories = scanner.nextLine();
                    System.out.println("Enter the recipe tags (separate with ','):");
                    var recipeTags = scanner.nextLine();
                    System.out.print("Do you want to save the recipe? (yes/no): ");
                    var saveRecipe = scanner.nextLine();
                    if (!saveRecipe.equalsIgnoreCase("yes")) {
                        System.out.println("Recipe not saved.");
                        break;
                    }
                    createFactory.createRecipe(recipeName, recipeIngredients, recipeCookingInstructions, recipeServingSize, recipeCategories, recipeTags);
                    break;
                case "modify":
                    System.out.println("Choose the recipe name:");
                    getCmd.getRecipies();
                    var recipeNameForModify = scanner.nextLine();
                    if (!getCmd.hasRecipe(recipeNameForModify)) {
                        System.out.println("Recipe not found.");
                        break;
                    }
                    System.out.println("Enter the recipe ingredients (separate with ','):");
                    var recipeIngredientsForModify = scanner.nextLine();
                    System.out.println("Enter the recipe cooking instructions:");
                    var recipeCookingInstructionsForModify = scanner.nextLine();
                    System.out.println("Enter the recipe categories (separate with ','):");
                    var recipeCategoriesModify = scanner.nextLine();
                    System.out.println("Enter the recipe tags (separate with ','):");
                    var recipeTagsModify = scanner.nextLine();
                    modifyFactory.modifyRecipe(recipeNameForModify, recipeIngredientsForModify, recipeCookingInstructionsForModify, recipeCategoriesModify, recipeTagsModify);
                    System.out.println("Do you want to undo this operation? (yes/no)");
                    var undoOption = scanner.nextLine();
                    if (undoOption.equalsIgnoreCase("yes")) {
                        modifyCmd.undo();
                    }
                    break;
                case "search":
                    System.out.println("Search for a recipe:");
                    var searchQuery = scanner.nextLine();
                    System.out.println(searchCmd.search(searchQuery));
                    break;
                case "rate":
                    System.out.println("Select the recipe to rate:");
                    getCmd.getRecipies();
                    var recipeIndex = scanner.nextInt();
                    if (getCmd.getRecipe(recipeIndex-1) == null) {
                        System.out.println("Recipe not found.");
                        break;
                    } else {
                        System.out.println("Enter the rating for the recipe:");
                        var rating = scanner.nextInt();
                        scanner.nextLine();
                        getCmd.getRecipe(recipeIndex - 1).addRating(rating);
                    }
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    continue;
            }

            System.out.println("Do you want to continue? (yes/no)");
            var continueOption = scanner.nextLine();
            if (!continueOption.equalsIgnoreCase("yes")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
