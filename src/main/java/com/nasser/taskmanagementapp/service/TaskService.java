package com.nasser.taskmanagementapp.service;

import com.nasser.taskmanagementapp.entity.Task;
import com.nasser.taskmanagementapp.repository.TaskRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getTasksByUserId(Long id) {
        return taskRepository.getAllTasksByUserId(id);
    }

    public void save(@Valid Task task) {
        taskRepository.save(task);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
