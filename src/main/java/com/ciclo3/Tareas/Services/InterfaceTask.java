package com.ciclo3.Tareas.Services;

import com.ciclo3.Tareas.Models.Task;

import java.util.List;

public interface InterfaceTask {
    
    public List<Task> getTask();

    public Task getOnlyOneTask(String id) throws Exception;

    public String getCreateTask(Task TaskIn);

    public Task getUpdateTask(Task TaskIn) throws Exception;

    public String getDeleteTask(String id) throws Exception;
}
