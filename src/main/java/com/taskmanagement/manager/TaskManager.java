package com.highradius.taskmanagement.manager;

import java.util.List;

import com.highradius.taskmanagement.exceptions.TaskManagementException;
import com.highradius.taskmanagement.pojo.Task;

public interface TaskManager {

    List<Task> allTasks() throws TaskManagementException;

    int insertTask(Task task) throws TaskManagementException;

    int updateTask(Task task) throws TaskManagementException;

    int deleteTask(int taskId) throws TaskManagementException;
}