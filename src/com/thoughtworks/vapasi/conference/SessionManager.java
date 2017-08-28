package com.thoughtworks.vapasi.conference;

import com.thoughtworks.vapasi.user.Attendee;
import com.thoughtworks.vapasi.util.Util;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Map<Integer, Session> sessionsList;

    public SessionManager() {
        this.sessionsList = new HashMap<Integer, Session>();
    }

    public Map<Integer, Session> getSessionsList() {
        return sessionsList;
    }

    public Map<Integer, Session> getSessionList() {
        return sessionsList;
    }

    public void addSession(Session session) {
        int id = Util.generateSessionId();
        session.setId(id);
        sessionsList.put(id, session);
    }

    public void removeSession(Session session) {
        if (sessionsList.containsKey(session.getId())) {
            sessionsList.remove(session.getId());
        }
    }

    public Session getAvailableSession() {
        Session session = null;

        for (Map.Entry<Integer, Session> entry : sessionsList.entrySet()) {
            if (entry.getValue().getStartTime() > Util.getCurrentHour()) {
                if (entry.getValue().isSeatAvailable()) {
                    session = entry.getValue();
                    break;
                } else {
                    System.out.println(entry.getValue().getName() + " session does not have seats available.");
                    continue;
                }
            } else {
                System.out.println(entry.getValue().getName() + " session is closed for registration");
                continue;
            }
        }
        return session;
    }

    public void registerForSession(Attendee attendee) {
        Session session = getAvailableSession();
        if (session != null) {
            session.registerAttendee(attendee);
        }
    }

}
