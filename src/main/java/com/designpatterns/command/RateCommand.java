package com.designpatterns.command;

import com.designpatterns.entities.Recipe;

public class RateCommand implements Command {
    @Override
    public String getCommandName() {
        return "rate";
    }

    @Override
    public void execute(Recipe recipe) {

    }
}
