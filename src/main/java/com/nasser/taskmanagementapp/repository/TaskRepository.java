package com.nasser.taskmanagementapp.repository;

import com.nasser.taskmanagementapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.user.id = :id")
    List<Task> getAllTasksByUserId(Long id);

}
