package net.sai.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import net.sai.entity.JournalEntry;

// when using /journal this whole class will be used then it will pick what to use in it

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

	private HashMap<Long, JournalEntry> hm = new HashMap<>();


	//	when using get this will be used 
	@GetMapping
	public ArrayList<JournalEntry> getAll() {	
		return new ArrayList<>(hm.values());
	}


	//	when using post this will be used
	@PostMapping
	public boolean createEntry(@RequestBody JournalEntry journalEntry) {
		System.out.println("Received entry: " + journalEntry.getTitle());
		hm.put(journalEntry.getId(), journalEntry);
		return true;
	}

	//only getting the name based on the id 
	@GetMapping("/{id}")
	public JournalEntry getJournalEntryById(@PathVariable long id) {
		return hm.get(id);
	}


	// DELETE entry by ID
	@DeleteMapping("/{id}")
	public JournalEntry deleteJournalEntryById(@PathVariable long id) {
		return hm.remove(id);
	}

	// PUT (update) entry by ID
	@PutMapping("/{id}")
	public JournalEntry updateJournalEntryById(@PathVariable long id, @RequestBody JournalEntry updatedEntry) {
		return hm.put(id, updatedEntry);

	}

}
