package com.model;

public class Vendors {

    protected int id;
    long phone_number;
    protected String email, store_name;
    protected String profile_pic, password;

    public Vendors() {
    }

    public Vendors(String store_name, long phone_number, String email, String profile_pic, String password) {
        super();
        this.store_name = store_name;
        this.phone_number = phone_number;
        this.email = email;
        this.profile_pic = profile_pic;
        this.password = password;
    }

    public Vendors(int id, String store_name, long phone_number, String email, String profile_pic, String password) {
        super();
        this.id = id;
        this.store_name = store_name;
        this.phone_number = phone_number;
        this.email = email;
        this.profile_pic = profile_pic;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void seProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
