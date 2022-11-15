package com.ciclo3.Tareas.Repositories;

import com.ciclo3.Tareas.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTask extends JpaRepository<Task,String> {
}
