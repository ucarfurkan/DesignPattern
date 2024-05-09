package com.designpatterns.command;

import com.designpatterns.entities.Recipe;

public class SearchCommand implements Command {
    @Override
    public String getCommandName() {
        return "search";
    }

    @Override
    public void execute(Recipe recipe) {

    }
}
