package net.sai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.sai.entity.JournalEntry;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, String>{

}
