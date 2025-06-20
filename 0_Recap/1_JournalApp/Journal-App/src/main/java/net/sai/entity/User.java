package net.sai.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	
	@DBRef
	private List<JournalEntry> journalEntries = new ArrayList<>();
 	
}
