package com.model;

public class BookType {

    protected int id;
    protected String type;

    public BookType() {
    }

    public BookType(String type) {
        super();
        this.type = type;
    }

    public BookType(int id, String type) {
        super();
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
