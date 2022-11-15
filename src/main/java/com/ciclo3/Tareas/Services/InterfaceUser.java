package com.ciclo3.Tareas.Services;

import com.ciclo3.Tareas.Models.User;

import java.util.List;

public interface InterfaceUser {
    public List<User> getUser();

    public User getOnlyOneUser(String id) throws Exception;

    public String getCreateUser(User userIn);

    public User getUpdateUser(User userIn) throws Exception;

    public String getDeleteUser(String id) throws Exception;


}
