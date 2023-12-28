package todo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import javax.persistence.Query;

import java.util.List;
import todo.dto.ToDoUser;
import todo.dto.ToDoTask;
@Component
public class TodoDao {
	
	@Autowired
	EntityManager manager;

	public void saveUser(ToDoUser user) {
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();	
	}
	public List<ToDoUser> findByEmail(String email) {
	return manager.createQuery("select x from ToDoUser x where email=?1").setParameter(1, email).getResultList();
	}
	public void saveTask(ToDoTask task) {
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
	}
	public List<ToDoTask> fetchAllTask(int id) {
		return manager.createQuery("select x from ToDoTask x where user_id=?1").setParameter(1, id).getResultList();
	}
	public ToDoTask fetchTaskById(int id) {
		return manager.find(ToDoTask.class,id);
	}
	public void updateUser(ToDoTask task) {
		manager.getTransaction().begin();
		manager.merge(task);
		manager.getTransaction().commit();	
	}
	public void deleteTask(ToDoTask task) {
		manager.getTransaction().begin();
		manager.remove(task);
		manager.getTransaction().commit();
	}
	public void updateTask(ToDoTask task) {
		manager.getTransaction().begin();
		manager.merge(task);
		manager.getTransaction().commit();
	}
}

	
	
	
