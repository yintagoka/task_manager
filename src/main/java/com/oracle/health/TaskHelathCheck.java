package com.oracle.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author Roy Krisnadi
 * @version 1.0
 * @since 19 Jul 2022
 */
public class TaskHelathCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
//        final String title = String.format(template, "TEST");
//        if (!title.contains("TEST")) {
//            return Result.unhealthy("Template doesn't include title");
//        }
        return Result.healthy();
    }
}
