package com.ciclo3.Tareas.Repositories;

import com.ciclo3.Tareas.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User,String> {
}
