package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
    }

    public TimeEntry() {

    }

    public long getId() {
        return id;
    }
}
