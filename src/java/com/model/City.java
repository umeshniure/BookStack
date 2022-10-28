package com.model;

public class City {

    private int id;
    private String city_name;

    public City() {
    }

    public City(String city_name) {
        super();
        this.city_name = city_name;
    }

    public City(int id, String city_name) {
        super();
        this.id = id;
        this.city_name = city_name;
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
     * @return the city_name
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * @param city_name the city_name to set
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
