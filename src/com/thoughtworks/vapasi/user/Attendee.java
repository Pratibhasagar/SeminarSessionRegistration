package com.thoughtworks.vapasi.user;

public class Attendee {
    private int id;
    private String name;
    private String company;

    public Attendee(String name, String company) {
        this.id = 0;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
