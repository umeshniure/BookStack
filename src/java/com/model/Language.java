package com.model;

public class Language {

    protected int id;
    protected String language_name;

    public Language() {
    }

    public Language(String language_name) {
        super();
        this.language_name = language_name;
    }

    public Language(int id, String language_name) {
        super();
        this.id = id;
        this.language_name = language_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }
}
