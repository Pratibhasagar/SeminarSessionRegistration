package com.thoughtworks.vapasi.myapp;

import com.thoughtworks.vapasi.conference.Admin;
import com.thoughtworks.vapasi.conference.Session;
import com.thoughtworks.vapasi.user.Attendee;
import com.thoughtworks.vapasi.util.*;

public class MyApplication {

    public static void main(String[] args) {

        Admin admin = new Admin("Sun Java India Conference");
        admin.getSessionManager().addSession(new Session(Util.generateSessionId(), "Core Java", 10, 13, 1));
        admin.getSessionManager().addSession(new Session(Util.generateSessionId(), "J2ME", 15, 16, 1));
        admin.getSessionManager().addSession(new Session(Util.generateSessionId(), "Java Enterprise", 16, 17, 1));

        admin.enrollAttendeeAndRegisterForSession(new Attendee("Pratibhasagar", "ThoughtWorks"));
        admin.enrollAttendeeAndRegisterForSession(new Attendee("Rajashri", "ThoughtWorks"));
        admin.enrollAttendeeAndRegisterForSession(new Attendee("Prachi", "ThoughtWorks"));
        admin.enrollAttendeeAndRegisterForSession(new Attendee("Meeraj", "Knot Solutions"));

        admin.getSessionManager().addSession(new Session(Util.generateSessionId(), "JavaScript", 17, 18, 2));
        admin.enrollAttendeeAndRegisterForSession(new Attendee("Ujwala", "ThoughtWorks"));

        Attendee attendee = new Attendee("Ravi", "ThoughtWorks");
        admin.getAttendeeManager().enrollAttendee(attendee);
        admin.getSessionManager().registerForSession(attendee);
    }
}
