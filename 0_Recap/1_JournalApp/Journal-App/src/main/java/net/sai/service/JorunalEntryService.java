package net.sai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sai.entity.JournalEntry;
import net.sai.repository.JournalEntryRepo;

@Component
public class JorunalEntryService {
	
	@Autowired
	private JournalEntryRepo journalEntryRepo;
	
	
	public void saveEntry(JournalEntry journalEntry) {

		journalEntryRepo.save(journalEntry);
	
	}
	
}
