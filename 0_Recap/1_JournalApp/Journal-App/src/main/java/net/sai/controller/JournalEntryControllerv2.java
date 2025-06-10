package net.sai.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.sai.entity.JournalEntry;
import net.sai.service.JorunalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

	@Autowired
	private JorunalEntryService jorunalEntryService;

	// GET all entries
	@GetMapping
	public List<JournalEntry> getAll() {
	    return jorunalEntryService.getAll();
	    }

	// POST a new entry
	@PostMapping
	public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
		jorunalEntryService.saveEntry(myEntry);
		return myEntry;
	}

	// GET by ID
	@GetMapping("/{id}")
	public JournalEntry getJournalEntryById(@PathVariable ObjectId id) {
		return jorunalEntryService.findById(id).orElse(null);
	}

	// DELETE by ID
	@DeleteMapping("/{id}")
	public boolean deleteJournalEntryById(@PathVariable ObjectId id) {
		Optional<JournalEntry> entry = jorunalEntryService.findById(id);
		jorunalEntryService.deleteById(id);
		return true;
	}

	@PutMapping("/id/{id}")
	public JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
	    JournalEntry old = jorunalEntryService.findById(id).orElse(null);
	    
	    if (old != null) {
	        if (newEntry.getTitle() != null && !newEntry.getTitle().isEmpty()) {
	            old.setTitle(newEntry.getTitle());
	        }

	        if (newEntry.getContent() != null && !newEntry.getContent().isEmpty()) {
	            old.setContent(newEntry.getContent());
	        }

	        if (newEntry.getDate() != null) {
	            old.setDate(newEntry.getDate());
	        }

	        jorunalEntryService.saveEntry(old);
	    }

	    return old;
	}

}
