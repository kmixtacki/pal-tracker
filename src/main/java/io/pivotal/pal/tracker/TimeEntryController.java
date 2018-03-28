package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create( @RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(
                timeEntryRepository.create(timeEntryToCreate),
                HttpStatus.CREATED);
    }

    @GetMapping("{l}")
    public ResponseEntity<TimeEntry> read(@PathVariable long l) {
        TimeEntry timeEntry = timeEntryRepository.find(l);
        return new ResponseEntity(
                timeEntry,
                timeEntry == null ? HttpStatus.NOT_FOUND :
                        HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(
                timeEntryRepository.list(),
                HttpStatus.OK);
    }

    @PutMapping("{l}")
    public ResponseEntity update(@PathVariable long l, @RequestBody TimeEntry expected) {
        TimeEntry timeEntryUpdate = timeEntryRepository.update(l, expected);
        if(timeEntryUpdate != null){
            return new ResponseEntity(timeEntryUpdate, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(timeEntryUpdate, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{l}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long l) {
        return new ResponseEntity(
                timeEntryRepository.delete(l),
                HttpStatus.NO_CONTENT);
    }

}
