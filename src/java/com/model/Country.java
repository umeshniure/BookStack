package com.model;

public class Country {

    private int id;
    private String country_name;

    public Country() {
    }

    public Country(String country_name) {
        super();
        this.country_name = country_name;
    }

    public Country(int id, String country_name) {
        super();
        this.id = id;
        this.country_name = country_name;
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
     * @return the country_name
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * @param country_name the country_name to set
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
