package net.sai.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "users")
@Data
public class User {


	@Id
	private Object id;
	@NonNull
	@Indexed(unique = true)
	private String username;
	
	@NonNull
	private String password;
	
}
