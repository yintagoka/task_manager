package com.oracle.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Roy Krisnadi
 * @version 1.0
 * @since 19 Jul 2022
 */

public class Task {
    private Long id;
    private String title;
    private Date created;
    private boolean completed;

    public Task() {

    }

    public Task(Long id, String title, Date created, boolean completed) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.completed = completed;
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
    public Date getCreated() {
        return created;
    }
    @JsonProperty
    public boolean isCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
