package com.oracle.db;

import com.oracle.api.Task;

import java.util.List;

/**
 * @author Roy Krisnadi
 * @version 1.0
 * @since 19 Jul 2022
 */
public class TaskRepository {
    /**
     * Read all
     * @return
     */
    public static List<Task> getTasks() {
        // TODO: get all
        return null;
    }

    /**
     * Read
     * @param id
     * @return
     */
    public static Task getTask(Long id) {
        // TODO: get id
        return null;
    }

    /**
     * Create / Update
     * @param task
     * @return
     */
    public static Task saveTask(Task task) {
        if (task.getId() != null) {
            // TODO: update
        }
        // TODO: insert
        return task;
    }

    public static boolean deleteTask(Long id) {
        // TODO: delete
        return true;
    }
}
