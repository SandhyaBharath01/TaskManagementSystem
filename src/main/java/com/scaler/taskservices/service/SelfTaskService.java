package com.scaler.taskservices.service;


import com.scaler.taskservices.exceptions.TaskNotFoundException;
import com.scaler.taskservices.models.User;
import com.scaler.taskservices.models.Task;
import com.scaler.taskservices.repositories.UserRepository;
import com.scaler.taskservices.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfTaskService")
public class SelfTaskService implements TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public SelfTaskService(TaskRepository taskRepository,
                           UserRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task getSingleTask(Long taskId) throws TaskNotFoundException {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isEmpty()) {
            throw new TaskNotFoundException("Task with id: " + taskId + " doesn't exist");
        }

        return taskOptional.get();
    }

//    @Override
//    public List<Task> getAllTasks() {
//        return List.of();
//    }

    @Override
    public Page<Task> getAllTasks(int pageNumber, int pageSize) {
        return taskRepository.findAll(PageRequest.of(pageNumber,
                pageSize,
                Sort.by("status").ascending()));
    }

    //PATCH
    @Override
    public Task updateTask(Long id, Task task) throws TaskNotFoundException {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException("Task with id : " + id + " doesn't exist");
        }

        Task taskInDB = optionalTask.get();

        if (task.getTitle() != null) {
            taskInDB.setTitle(task.getTitle());
        }


        return taskRepository.save(taskInDB);
    }

    @Override
    public Task replaceTask(Long id, Task task) {
//        return null;
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " not found"));
        existingTask.setTitle(task.getTitle());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
        existingTask.setDescription(task.getDescription());

        return taskRepository.save(existingTask);
    }
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task addNewTask(Task task) {
        User user = task.getUser();

//        if (category.getId() == null) {
//            // We need to create a new Category object in the DB first.
//            category = categoryRepository.save(category);
//            task.setCategory(category);
//        }

        return taskRepository.save(task);
    }
}