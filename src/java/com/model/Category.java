package com.model;

public class Category {

    protected int id;
    protected String category_name;

    public Category() {
    }

    public Category(String category_name) {
        super();
        this.category_name = category_name;
    }

    public Category(int id, String category_name) {
        super();
        this.id = id;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
