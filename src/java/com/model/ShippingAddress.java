package com.model;

public class ShippingAddress {

    private int id;
    private int user_id;
    private Integer postal_code;
    private String street;
    private String apartment;
    private int city;
    private String city_name;
    private int province;
    private String province_name;
    private int country;
    private String country_name;
    private boolean is_default;

    public ShippingAddress() {
    }

    public ShippingAddress(int user_id, String street, String apartment, int province, int city, int country, Integer postal_code, boolean is_default) {
        super();
        this.user_id = user_id;
        this.street = street;
        this.apartment = apartment;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postal_code = postal_code;
        this.is_default = is_default;
    }

    public ShippingAddress(int id, int user_id, String street, String apartment, int province, int city, int country, Integer postal_code, boolean is_default) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.street = street;
        this.apartment = apartment;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postal_code = postal_code;
        this.is_default = is_default;
    }

    public ShippingAddress(int id, int user_id, String street, String apartment, int city, String city_name, int province, String province_name, int country, String country_name, Integer postal_code, boolean is_default) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.street = street;
        this.apartment = apartment;
        this.city = city;
        this.city_name = city_name;
        this.province = province;
        this.province_name = province_name;
        this.country = country;
        this.country_name = country_name;
        this.postal_code = postal_code;
        this.is_default = is_default;
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
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the postal_code
     */
    public Integer getPostal_code() {
        return postal_code;
    }

    /**
     * @param postal_code the postal_code to set
     */
    public void setPostal_code(Integer postal_code) {
        this.postal_code = postal_code;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the apartment
     */
    public String getApartment() {
        return apartment;
    }

    /**
     * @param apartment the apartment to set
     */
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    /**
     * @return the city
     */
    public int getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(int city) {
        this.city = city;
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

    /**
     * @return the province
     */
    public int getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(int province) {
        this.province = province;
    }

    /**
     * @return the province_name
     */
    public String getProvince_name() {
        return province_name;
    }

    /**
     * @param province_name the province_name to set
     */
    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    /**
     * @return the country
     */
    public int getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(int country) {
        this.country = country;
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

    /**
     * @return the is_default
     */
    public boolean getIs_default() {
        return is_default;
    }

    /**
     * @param is_default the is_default to set
     */
    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }
}
