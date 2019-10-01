package com.example.analysis_journal.entity;

public class Analysis {
    private String name;
    private String result;
    private String url;

    public Analysis() {

    }

    public Analysis(String name, String result, String url) {
        this.name = name;
        this.result = result;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "name='" + name + '\'' +
                ", result='" + result + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
