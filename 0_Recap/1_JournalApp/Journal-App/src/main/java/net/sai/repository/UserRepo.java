package net.sai.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.sai.entity.JournalEntry;

public interface UserRepo extends MongoRepository<JournalEntry, ObjectId>{

}
