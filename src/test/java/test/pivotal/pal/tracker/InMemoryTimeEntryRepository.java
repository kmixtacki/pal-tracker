package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;

import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository {
    private HashMap<Long, TimeEntry> repo=new HashMap<Long, TimeEntry>();

    public TimeEntry find(long id){
        return null;
    }

    public List<TimeEntry> list () {
        return null;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        return null;
    }

    public void delete(long id) {
    }

    public TimeEntry create(TimeEntry timeEntry) {
        return null;
    }
}