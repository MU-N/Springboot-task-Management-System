package com.nasser.taskmanagementapp.controller;

import com.nasser.taskmanagementapp.entity.Task;
import com.nasser.taskmanagementapp.entity.User;
import com.nasser.taskmanagementapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String listTasks(@AuthenticationPrincipal User user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }
        List<Task> tasks = taskService.getTasksByUserId(user.getId());
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/new")
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @AuthenticationPrincipal User user) {
        if (result.hasErrors()) {
            return "task-form";
        }

        if (user != null) {
            task.setUser(user);
        } else {
            System.out.println("User is null - redirecting to login");
            return "redirect:/login";
        }

        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable Long id, Model model, @AuthenticationPrincipal User user) {
        if (user == null) {
            return "redirect:/login";
        }

        Task task = taskService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new SecurityException("Unauthorized access");
        }

        model.addAttribute("task", task);
        return "task-form";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable Long id, @Valid @ModelAttribute("task") Task updatedTask, BindingResult result, @AuthenticationPrincipal User user) {
        if (result.hasErrors()) {
            return "task-form";
        }

        Task task = taskService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new SecurityException("Unauthorized access");
        }

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setDueDate(updatedTask.getDueDate());
        task.setStatus(updatedTask.getStatus());

        taskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, @AuthenticationPrincipal User user) {
        if (user == null) {
            return "redirect:/login";
        }

        Task task = taskService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new SecurityException("Unauthorized access");
        }

        taskService.deleteById(id);
        return "redirect:/tasks";
    }
}
