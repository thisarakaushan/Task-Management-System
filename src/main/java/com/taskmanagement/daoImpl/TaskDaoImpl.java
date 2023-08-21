package com.highradius.taskmanagement.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.highradius.taskmanagement.util.HibernateUtil;
import com.highradius.taskmanagement.dao.TaskDao;
import com.highradius.taskmanagement.exceptions.TaskManagementException;
import com.highradius.taskmanagement.pojo.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

    @SuppressWarnings("unchecked")
	@Override
    public List<Task> allTasks() throws TaskManagementException {
    	Session session = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("FROM Task").list();
        } catch (Exception e) {
            throw new TaskManagementException("Error retrieving tasks: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public int insertTask(Task task) throws TaskManagementException {
    	Session session = null;
        try  {
        	session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            int taskId = (int) session.save(task);
            transaction.commit();
            return taskId;
        } catch (Exception e) {
            throw new TaskManagementException("Error adding task: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public int updateTask(Task task) throws TaskManagementException {
    	Session session = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(task);
            transaction.commit();
            return task.getTaskId();
        } catch (Exception e) {
            throw new TaskManagementException("Error updating task: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public int deleteTask(int taskId) throws TaskManagementException {
    	Session session = null;
    	int deletedCount = 0;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            
            Query query = session.createQuery("DELETE FROM Task WHERE task_id = :taskId");
            query.setParameter("taskId", taskId);
            deletedCount = query.executeUpdate();
            transaction.commit();
//            Task task = (Task) session.get(Task.class, taskId);
//            if (task != null) {
//            	
//            	session.update(task);
//            }
//            transaction.commit();
//            return (task != null) ? 1 : 0;
        } catch (Exception e) {
            throw new TaskManagementException("Error deleting task: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
		return deletedCount;
    }
}