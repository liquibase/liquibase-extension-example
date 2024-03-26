package com.example.command;

import liquibase.Scope;
import liquibase.command.CommandOverride;
import liquibase.command.CommandResultsBuilder;
import liquibase.command.core.StatusCommandStep;

@CommandOverride(override = StatusCommandStep.class)
public class MyStatusCommandStep extends StatusCommandStep {

    @Override
    public void run(CommandResultsBuilder resultsBuilder) throws Exception {
        super.run(resultsBuilder);
        Scope.getCurrentScope().getLog(MyStatusCommandStep.class).info("This is my customized status command");
    }
}
