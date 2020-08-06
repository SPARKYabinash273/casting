package com.jsn.jsrrcms;

/**
 * Created by Belal on 8/25/2017.
 */
public class fileup {

    public String name;
    public String url;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public fileup() {
    }

    public fileup(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}