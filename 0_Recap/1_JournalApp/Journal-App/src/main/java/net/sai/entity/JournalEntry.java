package net.sai.entity;

import java.sql.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "journal_entries")
@Data
public class JournalEntry {

	@Id
	private ObjectId id;
	@NonNull
	private String title;
	private Date date;
	private String content;

}
