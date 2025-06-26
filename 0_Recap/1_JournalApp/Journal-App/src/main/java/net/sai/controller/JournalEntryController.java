package net.sai.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import net.sai.entity.JournalEntry;
import net.sai.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("/{id}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId id) {
        return journalEntryService.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJournalEntryById(@PathVariable ObjectId id) {
        journalEntryService.findById(id).ifPresent(entry -> journalEntryService.deleteById(id));
    }

//    @PutMapping("/{id}")
//    public JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
//        return journalEntryService.findById(id).map(old -> {
//            String title = newEntry.getTitle();
//            String content = newEntry.getContent();
//
//            if (title != null && !title.trim().isEmpty()) {
//                old.setTitle(title.trim());
//            }
//
//            if (content != null && !content.trim().isEmpty()) {
//                old.setContent(content.trim());
//            }
//
//            if (newEntry.getDate() != null) {
//                old.setDate(newEntry.getDate());
//            }
//
//            journalEntryService.saveEntry(old);
//            return old;
//        }).orElse(null);
//    }

}
