package com.example.analysis_journal.entity;


public class Result {
    private String name;
    private String result;
    private String date;

    public Result() {
    }

    public Result(String name, String result, String date) {
        this.name = name;
        this.result = result;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
