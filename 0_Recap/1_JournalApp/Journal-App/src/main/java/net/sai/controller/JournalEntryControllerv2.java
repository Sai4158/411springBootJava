package net.sai.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import net.sai.service.JorunalEntryService;

// when using /journal this whole class will be used then it will pick what to use in it

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

	@Autowired
	private JorunalEntryService jorunalEntryService;

	//	when using get this will be used 
	@GetMapping
	public ArrayList<JournalEntry> getAll() {	
		return null;
	}


	//	when using post this will be used
	@PostMapping
	public boolean createEntry(@RequestBody JournalEntry myEntry) {

		jorunalEntryService.saveEntry(myEntry);
		return true;
	}

	//only getting the name based on the id 
	@GetMapping("/{id}")
	public JournalEntry getJournalEntryById(@PathVariable long id) {
		return null;
	}


	// DELETE entry by ID
	@DeleteMapping("/{id}")
	public JournalEntry deleteJournalEntryById(@PathVariable long id) {
		return null;
	}

	// PUT (update) entry by ID
	@PutMapping("/{id}")
	public JournalEntry updateJournalEntryById(@PathVariable long id, @RequestBody JournalEntry updatedEntry) {
		return null;
	}

}
