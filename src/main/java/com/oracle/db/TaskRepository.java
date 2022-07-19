package com.oracle.db;

import com.oracle.api.Task;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
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
        task1 = new Task(1L, "First Task", Instant.now(), false);
        task2 = new Task(2L, "Second Task", Instant.now(), false);
        task3 = new Task(3L, "Third Task", Instant.now(), false);
        task4 = new Task(4L, "Fourth Task", Instant.now(), false);
        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
        tasks.put(task3.getId(), task3);
        tasks.put(task4.getId(), task4);
    }
    /**
     * Read all
     * @return
     */
    public static List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    /**
     * Read
     * @param id
     * @return
     */
    public static Optional<Task> getTask(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    /**
     * Create / Update
     * @param task
     * @return
     */
    public static Optional<Task> saveTask(Task task) {
        if (task.getId() == null) {
            // created
            task.setId(getMaxId()+1);
            task.setCreated(Instant.now());
        }
        tasks.put(task.getId(), task);
        return Optional.of(task);
    }

    public static Task deleteTask(Long id) {
        return tasks.remove(id);
    }

    public static Long getMaxId() {
        return Collections.max(tasks.keySet());
    }
}
