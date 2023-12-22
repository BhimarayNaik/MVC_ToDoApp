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
	}
//	public void saveTask(Task task) {
//		manager.getTransaction().begin();
//		manager.persist(task);
//		manager.getTransaction().commit();
//	}
//	public void updateUser(ToDoUser dto) {
//		manager.getTransaction().begin();
//		manager.merge(dto);
//		manager.getTransaction().commit();	
//	}
//	public Task findTaskById(int id) {
//		return manager.find(Task.class, id);
//	}
//	public void updateTask(Task task) {
//		manager.getTransaction().begin();
//		manager.merge(task);
//		manager.getTransaction().commit();
//	}
//	public ToDoUser findById(int id) {
//		return manager.find(ToDoUser.class,id);	
//	}
//	public void deleteTask(Task task) {
//		manager.getTransaction().begin();
//		manager.remove(task);
//		manager.getTransaction().commit();
//	}

