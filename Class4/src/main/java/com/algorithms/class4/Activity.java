package com.algorithms.class4;

public class Activity {
    int start;
    int end;
    String name;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return name + " (" + start + "–" + end + ")";
    }
    
}
