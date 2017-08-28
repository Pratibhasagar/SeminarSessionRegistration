package com.thoughtworks.vapasi.conference;

import com.thoughtworks.vapasi.user.Attendee;

import java.util.HashMap;
import java.util.Map;


public class Session {
    private int id;
    private String name;

    /**
     * Value ranges from 0 to 23
     */
    private int startTime;
    /**
     * Value ranges from 0 to 23
     */
    private int endTime;
    private int duration;
    private int totalSeats;
    private int availableSeats;
    private Map<Integer, Attendee> registeredAttendees;

    public Session(int id, String name, int startTime, int endTime, int totalSeats) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = endTime - startTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        registeredAttendees = new HashMap<Integer, Attendee>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public boolean isSeatAvailable() {
        if (availableSeats > 0 && availableSeats <= totalSeats) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean registerAttendee(Attendee attendee) {
        if (!isSeatAvailable()) {
            System.out.println("Technical error. Registration failed.");
            return false;
        }
        if (registeredAttendees.containsKey(attendee.getId())) {
            System.out.println("Applicant already registered for this session ("
                    + this.name + " )");
            return false;
        }
        registeredAttendees.put(attendee.getId(), attendee);
        availableSeats--;
        System.out.println("Registration for " + name + " is successful.");
        return true;
    }

    public void unRegisterAttendee(Attendee attendee) {
        if (registeredAttendees.containsKey(attendee.getId())) {
            registeredAttendees.remove(attendee.getId());
            availableSeats++;
            System.out.println("Unregistration for " + name + " is successful.");
        }
    }
}
