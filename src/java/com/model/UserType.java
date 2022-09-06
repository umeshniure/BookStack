package com.model;

public class UserType {

    private int id;
    private String type;

    public UserType() {
    }

    public UserType(String user_type) {
        super();
        this.type = user_type;
    }

    public UserType(int id, String user_type) {
        super();
        this.id = id;
        this.type = user_type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user_type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the user_type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
