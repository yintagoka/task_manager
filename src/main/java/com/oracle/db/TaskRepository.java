package com.oracle.db;

import com.oracle.api.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Roy Krisnadi
 * @version 1.0
 * @since 19 Jul 2022
 */
public class TaskRepository {
    private static Map<Long, Task> tasks = new HashMap<>();
    private static Task task1;
    private static Task task2;
    private static Task task3;
    private static Task task4;
    static {
        task1 = new Task(1L, "First Task", new Date(), false);
        task2 = new Task(2L, "Second Task", new Date(), false);
        task3 = new Task(3L, "Third Task", new Date(), false);
        task4 = new Task(4L, "Fourth Task", new Date(), false);
        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
        tasks.put(task3.getId(), task3);
        tasks.put(task4.getId(), task4);
    }
    /**
     * Read all data.
     * @return all the available tasks.
     */
    public static List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    /**
     * Get 1 specific task.
     * @param id
     * @return task that correspond to the requested id.
     */
    public static Optional<Task> getTask(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    /**
     * Create / Update task.
     * Create if there's no id in the task.
     * Update if there's id in the task.
     * @param task
     * @return the newly created/updated task.
     */
    public static Optional<Task> saveTask(Task task) {
        if (task.getId() == null) {
            // created
            task.setId(getMaxId()+1);
            task.setCreated(new Date());
        }
        tasks.put(task.getId(), task);
        return Optional.of(task);
    }

    /**
     * Remove task that correspond to the requested id.
     * @param id
     * @return the removed task.
     */
    public static Task deleteTask(Long id) {
        return tasks.remove(id);
    }

    /**
     * Get maximum id of all the tasks that are available.
     * @return maximum id.
     */
    public static Long getMaxId() {
        return Collections.max(tasks.keySet());
    }
}
