package com.model;

import java.sql.Date;

public class Cart {

    private int id;
    private int user_id;
    private int book_id;
    private int quantity, price, discounted_price;
    private Date created_date;
    private String book_name, book_author, cover_photo_name;
    private int vendor_id;

    public Cart() {
    }

    public Cart(int user_id, int book_id, int quantity, Date created_date) {
        super();
        this.user_id = user_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.created_date = created_date;
    }

    public Cart(int id, int user_id, int book_id, int quantity, Date created_date) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.created_date = created_date;
    }

    // cart constructor for joined table
    public Cart(int id, int user_id, int book_id, int quantity, Date created_date, String book_name, String book_author, String cover_photo_name, int price, int discounted_price, int vendor_id) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.created_date = created_date;
        this.book_name = book_name;
        this.book_author = book_author;
        this.cover_photo_name = cover_photo_name;
        this.price = price;
        this.discounted_price = discounted_price;
        this.vendor_id = vendor_id;
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
     * @return the book_id
     */
    public int getBook_id() {
        return book_id;
    }

    /**
     * @param book_id the book_id to set
     */
    public void setBook_id(int book_id) {
        this.book_id = book_id;
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
     * @return the created_date
     */
    public Date getCreated_date() {
        return created_date;
    }

    /**
     * @param created_date the created_date to set
     */
    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
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
     * @return the cover_photo_name
     */
    public String getCover_photo_name() {
        return cover_photo_name;
    }

    /**
     * @param cover_photo_name the cover_photo_name to set
     */
    public void setCover_photo_name(String cover_photo_name) {
        this.cover_photo_name = cover_photo_name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the discounted_price
     */
    public int getDiscounted_price() {
        return discounted_price;
    }

    /**
     * @param discounted_price the discounted_price to set
     */
    public void setDiscounted_price(int discounted_price) {
        this.discounted_price = discounted_price;
    }

    /**
     * @return the vendor_id
     */
    public int getVendor_id() {
        return vendor_id;
    }

    /**
     * @param vendor_id the vendor_id to set
     */
    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }
}
