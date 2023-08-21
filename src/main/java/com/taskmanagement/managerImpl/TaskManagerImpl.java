package com.highradius.taskmanagement.managerImpl;

import java.util.List;

import com.highradius.taskmanagement.dao.TaskDao;
import com.highradius.taskmanagement.daoImpl.TaskDaoImpl;
import com.highradius.taskmanagement.exceptions.TaskManagementException;
import com.highradius.taskmanagement.manager.TaskManager;
import com.highradius.taskmanagement.pojo.Task;

public class TaskManagerImpl implements TaskManager {

    TaskDao taskDao = new TaskDaoImpl();

    public TaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
    public List<Task> allTasks() throws TaskManagementException {
        try {
            return taskDao.allTasks();
        } catch (Exception e) {
            throw new TaskManagementException("Error fetching tasks: " + e.getMessage());
        }
    }

    @Override
    public int insertTask(Task task) throws TaskManagementException {
        try {
            return taskDao.insertTask(task);
        } catch (Exception e) {
            throw new TaskManagementException("Error creating task: " + e.getMessage());
        }
    }

    @Override
    public int updateTask(Task task) throws TaskManagementException {
        try {
            return taskDao.updateTask(task);
        } catch (Exception e) {
            throw new TaskManagementException("Error updating task: " + e.getMessage());
        }
    }

    @Override
    public int deleteTask(int taskId) throws TaskManagementException {
        try {
            return taskDao.deleteTask(taskId);
        } catch (Exception e) {
            throw new TaskManagementException("Error deleting task: " + e.getMessage());
        }
    }
}
