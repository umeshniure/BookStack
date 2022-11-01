package com.model;

import java.sql.Date;

public class PaymentMethod {

    private int id;
    private int user_id;
    private int payment_type_id;
    private String payment_type_name;
    private String provider;
    private String account_number;
    private Date expiry_date;
    private boolean is_default;

    public PaymentMethod() {
    }

    public PaymentMethod(int user_id, int payment_type_id, String provider, String account_number, Date expiry_date, boolean is_default) {
        super();
        this.user_id = user_id;
        this.payment_type_id = payment_type_id;
        this.provider = provider;
        this.account_number = account_number;
        this.expiry_date = expiry_date;
        this.is_default = is_default;
    }

    public PaymentMethod(int id, int user_id, int payment_type_id, String payment_type_name, String provider, String account_number, Date expiry_date, boolean is_default) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.payment_type_id = payment_type_id;
        this.payment_type_name = payment_type_name;
        this.provider = provider;
        this.account_number = account_number;
        this.expiry_date = expiry_date;
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
     * @return the payment_type_id
     */
    public int getPayment_type_id() {
        return payment_type_id;
    }

    /**
     * @param payment_type_id the payment_type_id to set
     */
    public void setPayment_type_id(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    /**
     * @return the payment_type_name
     */
    public String getPayment_type_name() {
        return payment_type_name;
    }

    /**
     * @param payment_type_name the payment_type_name to set
     */
    public void setPayment_type_name(String payment_type_name) {
        this.payment_type_name = payment_type_name;
    }

    /**
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * @return the account_number
     */
    public String getAccount_number() {
        return account_number;
    }

    /**
     * @param account_number the account_number to set
     */
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    /**
     * @return the expiry_date
     */
    public Date getExpiry_date() {
        return expiry_date;
    }

    /**
     * @param expiry_date the expiry_date to set
     */
    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
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
