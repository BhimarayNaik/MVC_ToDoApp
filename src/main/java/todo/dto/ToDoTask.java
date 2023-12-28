package todo.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Data
public class ToDoTask {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int id;
	String name;
	String description;
	LocalDateTime createdTime;
	boolean status;
	
		@ManyToOne
		ToDoUser user;
	
}
