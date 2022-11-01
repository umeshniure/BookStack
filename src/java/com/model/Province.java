package com.model;

public class Province {

    private int id;
    private String province_name;

    public Province() {
    }

    public Province(String province_name) {
        super();
        this.province_name = province_name;
    }

    public Province(int id, String province_name) {
        super();
        this.id = id;
        this.province_name = province_name;
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
}
