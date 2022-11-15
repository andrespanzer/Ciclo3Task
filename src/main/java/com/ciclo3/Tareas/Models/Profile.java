package com.ciclo3.Tareas.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Profiles")
public class Profile {
    @Id
    private String id;
    @Column
    private String phone;

    @OneToMany(mappedBy = "profile")
    private List<User> userProfile;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    public Profile(String id, String phone, List<User> userProfile, Date createdAt, Date updatedAt) {
        this.id = id;
        this.phone = phone;
        this.userProfile = userProfile;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<User> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(List<User> userProfile) {
        this.userProfile = userProfile;
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
