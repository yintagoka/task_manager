package com.oracle;

import com.oracle.health.TaskHelathCheck;
import com.oracle.resources.TaskResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TaskManagerApplication extends Application<TaskManagerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TaskManagerApplication().run(args);
    }

    @Override
    public String getName() {
        return "TaskManager";
    }

    @Override
    public void initialize(final Bootstrap<TaskManagerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TaskManagerConfiguration configuration,
                    final Environment environment) {
        final TaskResource resource = new TaskResource();
        final TaskHelathCheck healthCheck = new TaskHelathCheck();
        environment.healthChecks().register("task", healthCheck);
        environment.jersey().register(resource);
    }

}
