package com.thoughtworks.vapasi.conference;

import com.thoughtworks.vapasi.user.Attendee;
import com.thoughtworks.vapasi.user.AttendeeManager;

/**
 * name:
 */
public class Admin {
    private String name;
    private AttendeeManager attendeeManager;
    private SessionManager sessionManager;

    public Admin(String name) {
        this.name = name;
        attendeeManager = new AttendeeManager();
        sessionManager = new SessionManager();
        System.out.println("\nWelcome to " + name);
    }

    public AttendeeManager getAttendeeManager() {
        return attendeeManager;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }


    public void enrollAttendeeAndRegisterForSession(Attendee attendee) {
        attendeeManager.enrollAttendee(attendee);
        sessionManager.registerForSession(attendee);
    }


}
