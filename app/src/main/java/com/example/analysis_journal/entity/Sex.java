package com.example.analysis_journal.entity;

public enum Sex {
    MALE("M"), FEMALE("W");

    private String text;

    Sex(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
