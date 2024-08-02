package com.scaler.taskservices.exceptions;

public class TaskNotFoundException extends Exception{
    private Long id;
    public TaskNotFoundException(String message){
        super(message);
    }
    public TaskNotFoundException(Long id) {
        super("Task not found: " + id);
        this.id = id;
    }

    public Long getTaskId() {
        return id;
    }
}
