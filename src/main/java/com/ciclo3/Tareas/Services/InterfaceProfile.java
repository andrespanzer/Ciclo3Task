package com.ciclo3.Tareas.Services;

import com.ciclo3.Tareas.Models.Profile;

import java.util.List;

public interface InterfaceProfile {
    
    public List<Profile> getProfile();

    public Profile getOnlyOneProfile(String id) throws Exception;

    public String getCreateProfile(Profile ProfileIn);

    public Profile getUpdateProfile(Profile ProfileIn) throws Exception;

    public String getDeleteProfile(String id) throws Exception;
}
