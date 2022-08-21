package com.model;

import java.sql.Date;

public class Cart {

    private int id;
    private int user_id;
    private int book_id;
    private int quantity;
    private Date created_date;

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
}
