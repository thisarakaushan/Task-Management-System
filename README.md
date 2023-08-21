# Task Management Web Application

This is a simple Task Management web application built using Spring, Struts, Hibernate, and JSON. The application allows users to manage tasks by performing CRUD (Create, Read, Update, Delete) operations on tasks.

### Features
  - **View Tasks**: Users can view a list of tasks in JSON format.
  - **Create Tasks**: Users can add new tasks to the list.
  - **Update Tasks**: Users can edit the details of existing tasks.
  - **Delete Tasks**: Users can remove tasks from the list.

### Technologies Used
  - [Spring](http://www.java2s.com/example/jar/s/download-springboot153releasejar-file.html) Framework
  - [Struts](http://www.java2s.com/Code/Jar/s/Downloadstrutscore1310jar.htm#google_vignette) Framework
  - [Hibernate ORM](https://jar-download.com/download-handling.php)
  - JSON Serialization/Deserialization
  - H2 Database (or your database of choice)
  - Web Dynamic Project

### Setup and Run

1. Clone the repository to your local machine:
```
git clone https://github.com/thisarakaushan/task-management-system.git
```

2. Navigate to the project directory:
```
cd task-management-system
```

3. Configure Database:

Configure the database settings in the `src/main/java/applicationContext.xml` file.

4. Build and Run the Application:

Using apache-tomcat:
The application will be accessible at `http://localhost:8080/task-management-system`

5. Use the application by accessing different URLs:

  - View Tasks: `http://localhost:8080/task-management-system/tasks/get-tasks`
  - Create Task: `http://localhost:8080/task-management-system/tasks/insert-task`
  - Update Task: `http://localhost:8080/task-management-system/tasks/update-task`
  - Delete Task: `http://localhost:8080/task-management-system/tasks/delete-task`

6. Project Structure
   
  * src/main/java: Contains Java source code.
      - com.highradius.taskmanagement.action: Struts action class.
      - com.highradius.taskmanagement.dao: DAO interface.
      - com.highradius.taskmanagement.daoImpl: DAO implementation class.
      - com.highradius.taskmanagement.exceptions: Custom exception class.
      - com.highradius.taskmanagement.pojo: Entity class.
      - com.highradius.taskmanagement.manager: Service interface.
      - com.highradius.taskmanagement.managerImpl: Manager implementation class.
      - com.highradius.taskmanagement.util: Hinernate configuration class
        
  * src/main/java: Contains application properties, Hibernate configuration, etc.

  * src/main/webapp: Contains JSP files, Struts configuration, etc.


Feel free to add more sections or customize the content to match your project's specific details and requirements.
