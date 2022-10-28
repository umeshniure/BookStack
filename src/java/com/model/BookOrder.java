package com.model;

import java.sql.Date;

public class BookOrder {

    private int user_id;
    private Integer shipping_postcode;
    private int order_status;
    private int transaction_satus;
    private Date order_date;
    private String id;
    private String transaction_id;
    private String order_status_name;
    private String transaction_satus_name;
    private String special_instruction;
    private String payment_method_name;
    private int payment_method;
    private int shipping_method;
    private String shipping_method_name;
    private String shipping_street;
    private String shipping_apartment;
    private String shipping_province;
    private String shipping_city;
    private String shipping_country;
    private String username;
    private Double order_subtotal_amount;
    private Double order_total_amount;
    private String book_name, book_author;
    private int quantity;
    private long phone_number;

    public BookOrder() {
    }

    public BookOrder(String id, int user_id, String transaction_id, Integer shipping_postcode, Date order_date, int order_status, int transaction_satus,
            String special_instruction, int payment_method, int shipping_method, String shipping_street, String shipping_apartment, String shipping_province,
            String shipping_city, String shipping_country, Double order_subtotal_amount, Double order_total_amount) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
        this.order_date = order_date;
        this.order_status = order_status;
        this.transaction_satus = transaction_satus;
        this.special_instruction = special_instruction;
        this.payment_method = payment_method;
        this.shipping_apartment = shipping_apartment;
        this.shipping_postcode = shipping_postcode;
        this.shipping_method = shipping_method;
        this.shipping_street = shipping_street;
        this.shipping_province = shipping_province;
        this.shipping_country = shipping_country;
        this.shipping_city = shipping_city;
        this.order_subtotal_amount = order_subtotal_amount;
        this.order_total_amount = order_total_amount;
    }

    public BookOrder(int user_id, String transaction_id, Integer shipping_postcode, Date order_date, int order_status, int transaction_satus,
            String special_instruction, int payment_method, int shipping_method, String shipping_street, String shipping_apartment, String shipping_province,
            String shipping_city, String shipping_country, Double order_subtotal_amount, Double order_total_amount) {
        super();
        this.user_id = user_id;
        this.transaction_id = transaction_id;
        this.order_date = order_date;
        this.order_status = order_status;
        this.transaction_satus = transaction_satus;
        this.special_instruction = special_instruction;
        this.payment_method = payment_method;
        this.shipping_apartment = shipping_apartment;
        this.shipping_postcode = shipping_postcode;
        this.shipping_method = shipping_method;
        this.shipping_street = shipping_street;
        this.shipping_province = shipping_province;
        this.shipping_country = shipping_country;
        this.shipping_city = shipping_city;
        this.order_subtotal_amount = order_subtotal_amount;
        this.order_total_amount = order_total_amount;
    }

    //constructor for joined transaction status and order status table
    public BookOrder(String id, int user_id, String transaction_id, Integer shipping_postcode, Date order_date, int order_status, String order_status_name, int transaction_satus, String transaction_satus_name,
            String special_instruction, int payment_method, int shipping_method, String shipping_street, String shipping_apartment, String shipping_province,
            String shipping_city, String shipping_country, Double order_subtotal_amount, Double order_total_amount, String username, String book_name, String book_author) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
        this.order_date = order_date;
        this.order_status = order_status;
        this.order_status_name = order_status_name;
        this.transaction_satus = transaction_satus;
        this.transaction_satus_name = transaction_satus_name;
        this.special_instruction = special_instruction;
        this.payment_method = payment_method;
        this.shipping_apartment = shipping_apartment;
        this.shipping_postcode = shipping_postcode;
        this.shipping_method = shipping_method;
        this.shipping_street = shipping_street;
        this.shipping_province = shipping_province;
        this.shipping_country = shipping_country;
        this.shipping_city = shipping_city;
        this.order_subtotal_amount = order_subtotal_amount;
        this.order_total_amount = order_total_amount;
        this.username = username;
        this.book_name = book_name;
        this.book_author = book_author;
    }

    //constructor for joined transaction status and order status table
    public BookOrder(String id, int user_id, String transaction_id, Integer shipping_postcode, Date order_date, int order_status, String order_status_name, int transaction_satus, String transaction_satus_name,
            String special_instruction, int payment_method, int shipping_method, String shipping_street, String shipping_apartment, String shipping_province,
            String shipping_city, String shipping_country, Double order_subtotal_amount, Double order_total_amount, String username, String book_name, String book_author, int quantity, long phone_number) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
        this.order_date = order_date;
        this.order_status = order_status;
        this.order_status_name = order_status_name;
        this.transaction_satus = transaction_satus;
        this.transaction_satus_name = transaction_satus_name;
        this.special_instruction = special_instruction;
        this.payment_method = payment_method;
        this.shipping_apartment = shipping_apartment;
        this.shipping_postcode = shipping_postcode;
        this.shipping_method = shipping_method;
        this.shipping_street = shipping_street;
        this.shipping_province = shipping_province;
        this.shipping_country = shipping_country;
        this.shipping_city = shipping_city;
        this.order_subtotal_amount = order_subtotal_amount;
        this.order_total_amount = order_total_amount;
        this.username = username;
        this.book_name = book_name;
        this.book_author = book_author;
        this.quantity = quantity;
        this.phone_number = phone_number;
    }

    public BookOrder(String id, double order_total_amount, double order_subtotal_amount, Date order_date, Integer postalcode,
            String street, String apartment, String city, String province, String country, int payment_method, int shipping_method, String shipping_method_name) {
        this.id = id;
        this.order_total_amount = order_total_amount;
        this.order_subtotal_amount = order_subtotal_amount;
        this.order_date = order_date;
        this.shipping_postcode = postalcode;
        this.shipping_street = street;
        this.shipping_apartment = apartment;
        this.shipping_city = city;
        this.shipping_province = province;
        this.shipping_country = country;
        this.payment_method = payment_method;
        this.shipping_method = shipping_method;
        this.shipping_method_name = shipping_method_name;
    }

    public BookOrder(String id, int user_id, Date order_date, int order_status, String order_status_name, double order_total_amount, String username) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.order_status = order_status;
        this.order_status_name = order_status_name;
        this.order_total_amount = order_total_amount;
        this.username = username;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
     * @return the transaction_id
     */
    public String getTransaction_id() {
        return transaction_id;
    }

    /**
     * @param transaction_id the transaction_id to set
     */
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    /**
     * @return the shipping_postcode
     */
    public Integer getShipping_postcode() {
        return shipping_postcode;
    }

    /**
     * @param shipping_postcode the shipping_postcode to set
     */
    public void setShipping_postcode(Integer shipping_postcode) {
        this.shipping_postcode = shipping_postcode;
    }

    /**
     * @return the order_date
     */
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    /**
     * @return the order_status
     */
    public int getOrder_status() {
        return order_status;
    }

    /**
     * @param order_status the order_status to set
     */
    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    /**
     * @return the transaction_satus
     */
    public int getTransaction_satus() {
        return transaction_satus;
    }

    /**
     * @param transaction_satus the transaction_satus to set
     */
    public void setTransaction_satus(int transaction_satus) {
        this.transaction_satus = transaction_satus;
    }

    /**
     * @return the special_instruction
     */
    public String getSpecial_instruction() {
        return special_instruction;
    }

    /**
     * @param special_instruction the special_instruction to set
     */
    public void setSpecial_instruction(String special_instruction) {
        this.special_instruction = special_instruction;
    }

    /**
     * @return the payment_method
     */
    public int getPayment_method() {
        return payment_method;
    }

    /**
     * @param payment_method the payment_method to set
     */
    public void setPayment_method(int payment_method) {
        this.payment_method = payment_method;
    }

    /**
     * @return the shipping_method
     */
    public int getShipping_method() {
        return shipping_method;
    }

    /**
     * @param shipping_method the shipping_method to set
     */
    public void setShipping_method(int shipping_method) {
        this.shipping_method = shipping_method;
    }

    /**
     * @return the shipping_street
     */
    public String getShipping_street() {
        return shipping_street;
    }

    /**
     * @param shipping_street the shipping_street to set
     */
    public void setShipping_street(String shipping_street) {
        this.shipping_street = shipping_street;
    }

    /**
     * @return the shipping_apartment
     */
    public String getShipping_apartment() {
        return shipping_apartment;
    }

    /**
     * @param shipping_apartment the shipping_apartment to set
     */
    public void setShipping_apartment(String shipping_apartment) {
        this.shipping_apartment = shipping_apartment;
    }

    /**
     * @return the shipping_province
     */
    public String getShipping_province() {
        return shipping_province;
    }

    /**
     * @param shipping_province the shipping_province to set
     */
    public void setShipping_province(String shipping_province) {
        this.shipping_province = shipping_province;
    }

    /**
     * @return the shipping_city
     */
    public String getShipping_city() {
        return shipping_city;
    }

    /**
     * @param shipping_city the shipping_city to set
     */
    public void setShipping_city(String shipping_city) {
        this.shipping_city = shipping_city;
    }

    /**
     * @return the shipping_country
     */
    public String getShipping_country() {
        return shipping_country;
    }

    /**
     * @param shipping_country the shipping_country to set
     */
    public void setShipping_country(String shipping_country) {
        this.shipping_country = shipping_country;
    }

    /**
     * @return the order_subtotal_amount
     */
    public Double getOrder_subtotal_amount() {
        return order_subtotal_amount;
    }

    /**
     * @param order_subtotal_amount the order_subtotal_amount to set
     */
    public void setOrder_subtotal_amount(Double order_subtotal_amount) {
        this.order_subtotal_amount = order_subtotal_amount;
    }

    /**
     * @return the order_total_amount
     */
    public Double getOrder_total_amount() {
        return order_total_amount;
    }

    /**
     * @param order_total_amount the order_total_amount to set
     */
    public void setOrder_total_amount(Double order_total_amount) {
        this.order_total_amount = order_total_amount;
    }

    /**
     * @return the order_status_name
     */
    public String getOrder_status_name() {
        return order_status_name;
    }

    /**
     * @param order_status_name the order_status_name to set
     */
    public void setOrder_status_name(String order_status_name) {
        this.order_status_name = order_status_name;
    }

    /**
     * @return the transaction_satus_name
     */
    public String getTransaction_satus_name() {
        return transaction_satus_name;
    }

    /**
     * @param transaction_satus_name the transaction_satus_name to set
     */
    public void setTransaction_satus_name(String transaction_satus_name) {
        this.transaction_satus_name = transaction_satus_name;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the book_name
     */
    public String getBook_name() {
        return book_name;
    }

    /**
     * @param book_name the book_name to set
     */
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    /**
     * @return the book_author
     */
    public String getBook_author() {
        return book_author;
    }

    /**
     * @param book_author the book_author to set
     */
    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the phone_number
     */
    public long getPhone_number() {
        return phone_number;
    }

    /**
     * @param phone_number the phone_number to set
     */
    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * @return the payment_method_name
     */
    public String getPayment_method_name() {
        return payment_method_name;
    }

    /**
     * @param payment_method_name the payment_method_name to set
     */
    public void setPayment_method_name(String payment_method_name) {
        this.payment_method_name = payment_method_name;
    }

    /**
     * @return the shipping_method_name
     */
    public String getShipping_method_name() {
        return shipping_method_name;
    }

    /**
     * @param shipping_method_name the shipping_method_name to set
     */
    public void setShipping_method_name(String shipping_method_name) {
        this.shipping_method_name = shipping_method_name;
    }

}
