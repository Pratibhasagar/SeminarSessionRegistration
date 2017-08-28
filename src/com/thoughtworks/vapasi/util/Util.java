package com.thoughtworks.vapasi.util;

import java.time.ZonedDateTime;

public final class Util {

    private static int attendeeId = 0;
    private static int sessionId = 0;

    public static int generateAttendeeId(){
        return attendeeId++;
    }

    public static int generateSessionId(){
        return sessionId++;
    }

    public static int getCurrentHour() {
        ZonedDateTime zdt = ZonedDateTime.now();
        return zdt.getHour();
    }
}
