package com.example.chores;

public class Friend {

    private String name;
    private String job;
    private boolean gender;

    public Friend(String name, boolean gender, String job) {
        this.name = name;
        this.gender = gender;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public boolean isGender() {
        return gender;
    }
}
