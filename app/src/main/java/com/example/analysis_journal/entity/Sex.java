package com.example.analysis_journal.entity;

public enum Sex {
    M("M"), W("W");

    private String text;

    Sex(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
