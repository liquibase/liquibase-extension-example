package com.example.command;

import com.datical.liquibase.ext.command.ProUpdateCommandStep;
import liquibase.Scope;
import liquibase.command.CommandOverride;
import liquibase.command.CommandResultsBuilder;
import liquibase.command.core.UpdateCommandStep;
import liquibase.database.Database;
import liquibase.executor.Executor;
import liquibase.executor.ExecutorService;
import liquibase.statement.core.RawSqlStatement;

import java.util.List;
import java.util.Map;

// The double override below is to be fixed in Liquibase 4.28.0
//@CommandOverride(override = UpdateCommandStep.class) // use this if commercial is NOT  present (like in a spring app)
@CommandOverride(override = ProUpdateCommandStep.class) // use this if commercial is present (like in command line)
public class MyUpdateCommandStep extends UpdateCommandStep {
    @Override
    public void run(CommandResultsBuilder resultsBuilder) throws Exception {
        Scope.getCurrentScope().getLog(MyUpdateCommandStep.class).info("*****BEFORE TASK!");

        Database database = (Database) resultsBuilder.getCommandScope().getDependency(Database.class);
        final Executor executor = Scope.getCurrentScope().getSingleton(ExecutorService.class).getExecutor("jdbc", database);
        List<Map<String, ?>> queryResult = executor.queryForList(new RawSqlStatement("select * from databasechangelog"));
            Scope.getCurrentScope().getLog(MyUpdateCommandStep.class).info(String.format("*****We currently have %d entries in dbcl", queryResult.size()));
        super.run(resultsBuilder);

        Scope.getCurrentScope().getLog(MyUpdateCommandStep.class).info("************* CLEAN UP?");
    }
}
