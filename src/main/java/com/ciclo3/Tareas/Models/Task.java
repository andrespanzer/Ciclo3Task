package com.ciclo3.Tareas.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Tasks")
public class Task {

    @Id
    private String id;
    @Column
    private String title;
    @Column
    private String description;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Enum_State.class,fetch = FetchType.EAGER)
    private List<Enum_State> state;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Task userTask;

    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    public Task() {
    }

    public Task(String id, String title, String description, List<Enum_State> state, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Task(Task userTask) {
        this.userTask = userTask;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getUserTask() {
        return userTask;
    }

    public void setUserTask(Task userTask) {
        this.userTask = userTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Enum_State> getState() {
        return state;
    }

    public void setState(List<Enum_State> state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
