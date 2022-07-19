package com.oracle.resources;

import com.codahale.metrics.annotation.Timed;
import com.oracle.api.Task;
import com.oracle.db.TaskRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Roy Krisnadi
 * @version 1.0
 * @since 19 Jul 2022
 */
@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public TaskResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Response getTasks() {
        return Response.ok()(TaskRepository.)
    }
    @GET
    @Timed
    public Task sayHello(@QueryParam("title") Optional<String> title) {
        final String value = String.format(template, title.orElse(defaultName));
        return new Task(counter.incrementAndGet(), value, Instant.now(), false);
    }
}
