package com.model;

public class BookCover {

    protected int id;
    protected String cover_type;

    public BookCover() {
    }

    public BookCover(String cover_type) {
        super();
        this.cover_type = cover_type;
    }

    public BookCover(int id, String cover_type) {
        super();
        this.id = id;
        this.cover_type = cover_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover_type() {
        return cover_type;
    }

    public void setCover_type(String cover_type) {
        this.cover_type = cover_type;
    }
}
