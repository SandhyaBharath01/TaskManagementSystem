package com.scaler.taskservices.controllers;

import com.scaler.taskservices.exceptions.TaskNotFoundException;
import com.scaler.taskservices.models.Task;
import com.scaler.taskservices.service.TaskService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import  java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    //Declaration and injection of task service
    private TaskService taskService;

    //Constructor
    public TaskController(@Qualifier("selfTaskService") TaskService taskService){
        this.taskService = taskService;
    }
//    @GetMapping("/{id}")
//    public Task getTaskById(@PathVariable("id") Long id){
//        return taskService.getSingleTask(id);
//    }
//    Exception Handling
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) throws TaskNotFoundException {
        ResponseEntity<Task> response = new ResponseEntity<>(
                taskService.getSingleTask(id),
                HttpStatus.OK
        );
        return response;
    }

    @GetMapping()
    public Page<Task> getAllTasks(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws TaskNotFoundException {
        return taskService.getAllTasks(pageNumber, pageSize);
    }
    //Update-Patch
    @PatchMapping ("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) throws TaskNotFoundException {
        return taskService.updateTask(id, task);
    }

    @PutMapping("/{id}")
    public Task replaceTask(@PathVariable("id") Long id, @RequestBody Task task){
        return taskService.replaceTask(id, task);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);
    }
    @PostMapping
    public Task addNewTask(@RequestBody Task task){
        return taskService.addNewTask(task);
    }

}
