package com.thoughtworks.vapasi.user;

import com.thoughtworks.vapasi.util.Util;

import java.util.HashMap;
import java.util.Map;

public class AttendeeManager {
    private Map<Integer, Attendee> attendeesList;

    public AttendeeManager() {
        this.attendeesList = new HashMap<Integer, Attendee>();
    }

    public Map<Integer, Attendee> getAttendeeList() {
        return attendeesList;
    }

    public void enrollAttendee(Attendee attendee) {
        int id = Util.generateAttendeeId();
        attendee.setId(id);
        attendeesList.put(id, attendee);
        System.out.println("\nWelcome " + attendee.getName() + " !!");
    }

    public void disEnrollAttendee(Attendee attendee) {
        if (attendeesList.containsKey(attendee.getId())) {
            attendeesList.remove(attendee.getId());
        }
    }
}
