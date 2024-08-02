package com.scaler.taskservices.service;

import com.scaler.taskservices.exceptions.TaskNotFoundException;
import com.scaler.taskservices.models.Task;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import  java.util.List;

@Service("selfTaskService")
public interface TaskService {

//    Product getSingleProduct(Long productId);
    //Exception Handling
    Task getSingleTask(Long taskId) throws TaskNotFoundException;
    Page<Task> getAllTasks(int pageNumber, int pageSize);
    Task updateTask(Long id, Task task) throws TaskNotFoundException;
    Task replaceTask(Long id, Task task);
    void deleteTask(Long id);
    Task addNewTask(Task task);
}
