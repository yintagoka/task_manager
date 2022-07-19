package com.oracle.resources;

import com.codahale.metrics.annotation.Timed;
import com.oracle.api.Task;
import com.oracle.db.TaskRepository;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Roy Krisnadi
 * @version 1.0
 * @since 19 Jul 2022
 */
@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    @GET
    @Timed
    public Response getTasks() {
        return Response.ok(TaskRepository.getTasks()).build();
    }

    @GET
    @Path("/{id}")
    @Timed
    public Response getTask(@PathParam("id") Long id) {
        Optional<Task> optionalTask = TaskRepository.getTask(id);
        if (optionalTask.isEmpty()) {
            Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(optionalTask.get()).build();
    }

    @POST
    public Response createTask(Task task) {
        Optional<Task> optionalTask = TaskRepository.getTask(task.getId());
        if (optionalTask.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Task already existed.").build();
        }
        return Response.ok(TaskRepository.saveTask(task)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTask(@PathParam("id") Long id, Task task) {
        Optional<Task> optionalTask = TaskRepository.getTask(id);
        if (optionalTask.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Task does not exist.").build();
        }
        return Response.ok(TaskRepository.saveTask(task)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeTask(@PathParam("id") Long id) {
        Optional<Task> optionalTask = TaskRepository.getTask(id);
        if (optionalTask.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Task does not exist.").build();
        }
        return Response.ok(TaskRepository.deleteTask(id)).build();
    }

}
