package com.model;

public class Users {

    protected int id, user_type;
    protected long phone_number;
    protected String firstname, lastname, email, store_name;
    protected String profile_pic;
    protected String profile_pic_name;
    protected String password;

    public Users() {
    }

    public Users(String firstname, String lastname, String store_name, long phone_number, String email, String profile_pic, String profile_pic_name, String password, int user_type) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.store_name = store_name;
        this.phone_number = phone_number;
        this.email = email;
        this.profile_pic = profile_pic;
        this.profile_pic_name = profile_pic_name;
        this.password = password;
        this.user_type = user_type;
    }

    public Users(int id, String firstname, String lastname, String store_name, long phone_number, String email, String profile_pic, String profile_pic_name, String password, int user_type) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.store_name = store_name;
        this.phone_number = phone_number;
        this.email = email;
        this.profile_pic = profile_pic;
        this.profile_pic_name = profile_pic_name;
        this.password = password;
        this.user_type = user_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    /**
     * @return the profile_pic_name
     */
    public String getProfile_pic_name() {
        return profile_pic_name;
    }

    /**
     * @param profile_pic_name the profile_pic_name to set
     */
    public void setProfile_pic_name(String profile_pic_name) {
        this.profile_pic_name = profile_pic_name;
    }
}
