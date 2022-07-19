package com.oracle.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

/**
 * @author Roy Krisnadi
 * @version 1.0
 * @since 19 Jul 2022
 */

public class Task {
    private Long id;
    private String title;
    private Instant created;
    private boolean isCompleted;

    public Task() {

    }

    public Task(Long id, String title, Instant created, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.isCompleted = isCompleted;
    }


    @JsonProperty
    public Long getId() {
        return id;
    }
    @JsonProperty
    public String getTitle() {
        return title;
    }
    @JsonProperty
    public Instant getCreated() {
        return created;
    }
    @JsonProperty
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
