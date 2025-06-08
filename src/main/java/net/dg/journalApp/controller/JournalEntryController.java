package net.dg.journalApp.controller;

import net.dg.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    public Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return  new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("/id/{userId}")
    public JournalEntry getJournalEntryById(@PathVariable Long userId){
        return journalEntries.get(userId);

    }
    @DeleteMapping("/id/{userId}")
    public JournalEntry removeJournalEntryById(@PathVariable Long userId){
        return journalEntries.remove(userId);

    }
    @PutMapping("/id/{userId}")
    public JournalEntry updateJournalById(@PathVariable Long userId, @RequestBody JournalEntry myEntry){
        return journalEntries.put(userId,myEntry);
    }


}
