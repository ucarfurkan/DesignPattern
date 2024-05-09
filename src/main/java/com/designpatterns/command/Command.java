package com.designpatterns.command;

import com.designpatterns.entities.Recipe;

public interface Command {

    String getCommandName();

    void execute(Recipe recipe);
}
